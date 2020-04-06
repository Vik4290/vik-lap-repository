package com.zom.pom.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.zom.pom.Utilites.ExcelReader;
import com.zom.pom.Utilites.ExtentManager;
import com.zom.pom.Utilites.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;

public class Page {

	public static WebDriver driver;
	public static TopMenu menu;
	
	//-------Additional parameters
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log  = Logger.getLogger("devpinoyLogger");
	static final String path = "C:\\Users\\Vikram\\Vik_POM\\com.zom.pom\\src\\test\\resources\\Properties\\log4j.properties";
		
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentReports rep = ExtentManager.createInstance("./reports/extent.html");
	public static ExtentTest test;
	
	//--------Need to check this
	public static String browser;
	
	
	/*
	 * Logs,
	 * Properties - OR, Config
	 * Excel
	 * Implicit and ExplicitWait
	 * Extent Reports
	 */

	
	public Page()
	{
		
		
		if(driver==null)
		{
	
	//******************* "Config" and "OR" properties Definition***********************		
			PropertyConfigurator.configure(path);	
		    log.debug("Property configured Successully");			
				try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\Properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			//***************************Jenkins Browser filter configuration*********************************
			
			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				browser = System.getenv("browser");
			} else {

				browser = config.getProperty("browser");

			}

			config.setProperty("browser", browser);

			
			
	//****************************Initializing Driver************************************************
		
	//*************************If Browser is Firefox**********************************************
		if (config.getProperty("browser").equals("firefox")) {

						driver = new FirefoxDriver();

			} 

			//*************************If Browser is Chrome**********************************************
			
			else if (config.getProperty("browser").equals("chrome")) {
			
				WebDriverManager.chromedriver().setup();

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");

			driver = new ChromeDriver(options);
			}
			
		//*************************If Browser is IE**********************************************
			
			else if (config.getProperty("browser").equals("ie")) {

				//System.setProperty("webdriver.ie.driver",
					//	System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}
	
		
		//*********************************Navigate to Browser*************************************
		
		
		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to : " + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		
		//wait = new WebDriverWait(driver, 5);
		
		menu = new TopMenu(driver);
		
		
	//*******************************************Initializing Browser in my way*************************					
/*
			
			WebDriverManager.chromedriver().setup();
		
	    Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
		
		//*****************Initializing Browser*****************
		driver = new ChromeDriver(options);
		
		*/
		
		//*****************Navigate to URL*****************
		
		/*driver.navigate().to("https://www.zoho.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		menu = new TopMenu();*/
		
		
		}
	}
	
public static void quit(){
		
		driver.quit();
		
	}
	

//Common Keywords
public static void click(String locator) {

	if (locator.endsWith("_CSS")) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		log.debug("Clicking on an Element : "+locator);
		test.log(test.getStatus(), "Clicking on : " + locator);
	} else if (locator.endsWith("_XPATH")) {
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
		log.debug("Clicking on an Element : "+locator);
		test.log(test.getStatus(), "Clicking on : " + locator);
		
	} else if (locator.endsWith("_ID")) {
		driver.findElement(By.id(OR.getProperty(locator))).click();
		log.debug("Clicking on an Element : "+locator);
		test.log(test.getStatus(), "Clicking on : " + locator);
	}
	
}

public static boolean isdisplayed(String locator) {

	if (locator.endsWith("_CSS")) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).isDisplayed();
		log.debug("Clicking on an Element : "+locator);
		test.log(test.getStatus(), "Clicking on : " + locator);
		return true;
	} else if (locator.endsWith("_XPATH")) {
		driver.findElement(By.xpath(OR.getProperty(locator))).isDisplayed();
		log.debug("Clicking on an Element : "+locator);
		test.log(test.getStatus(), "Clicking on : " + locator);
		return true;
	} else if (locator.endsWith("_ID")) {
		driver.findElement(By.id(OR.getProperty(locator))).isDisplayed();
		log.debug("Clicking on an Element : "+locator);
		test.log(test.getStatus(), "Clicking on : " + locator);
		return true;
	}
	else {
		return false;
	}
		
}






public static void type(String locator, String value) {

	if (locator.endsWith("_CSS")) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
	} else if (locator.endsWith("_XPATH")) {
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
	} else if (locator.endsWith("_ID")) {
		driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
	}

	log.debug("Typing in an Element : "+locator+" entered value as : "+value);
	test.log(test.getStatus(), "Typing in : " + locator + " entered value as " + value);

}

static WebElement dropdown;

public void select(String locator, String value) {

	if (locator.endsWith("_CSS")) {
		dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
	} else if (locator.endsWith("_XPATH")) {
		dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
	} else if (locator.endsWith("_ID")) {
		dropdown = driver.findElement(By.id(OR.getProperty(locator)));
	}
	
	Select select = new Select(dropdown);
	select.selectByVisibleText(value);

	log.debug("Selecting from an element : "+locator+" value as : "+value);
	test.log(test.getStatus(), "Selecting from dropdown : " + locator + " value as " + value);

}

public boolean isElementPresent(By by) {

	try {

		driver.findElement(by);
		return true;

	} catch (NoSuchElementException e) {

		return false;

	}

}

public static void verifyEquals(String expected, String actual) throws IOException {

	try {

		Assert.assertEquals(actual, expected);

	} catch (Throwable t) {

		Utilities.captureScreenshot();
		// ReportNG
		Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
		Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName
				+ " height=200 width=200></img></a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		// Extent Reports
		test.log(test.getStatus(), " Verification failed with exception : " + t.getMessage());
		//test.log(test.getStatus(), test.addScreenCapture(Utilities.screenshotName));

	}

}


}
