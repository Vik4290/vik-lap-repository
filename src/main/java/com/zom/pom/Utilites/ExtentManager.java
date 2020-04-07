package com.zom.pom.Utilites;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.zom.pom.base.Page;



public class ExtentManager extends Page{
	
	
	
	private static ExtentSparkReporter extentReporter;
		
	
    public static ExtentReports createInstance(String fileName)  {

    	
    	//htmlReporter = new ExtentHtmlReporter("./reports/extent.html");

    			extentReporter = new ExtentSparkReporter(fileName);
    	
   			
    			extentReporter.config().setEncoding("utf-8");
    			extentReporter.config().setDocumentTitle("Vikram Automation Reports");
    			extentReporter.config().setReportName("Automation Test Results");
    			extentReporter.config().setTheme(Theme.DARK);
    			
    			extent = new ExtentReports();
    			extent.attachReporter(extentReporter);

    			extent.setSystemInfo("Automation Tester", "Vikram B");
    			extent.setSystemInfo("Orgainzation", "Personal");
    			extent.setSystemInfo("Build No", "P-1/Apr/2020");

    //*****************************************Old code********************************************	
    	
    	
    	/*        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
               
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Rahul Arora");
        extent.setSystemInfo("Organization", "Way2Automation");
        extent.setSystemInfo("Build no", "W2A-1234");
       
        */
        
        return extent;
    }

    
  /*  public static String screenshotPath;
	public static String screenshotName;
	
	public static void captureScreenshot() {

		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

*/
    
}
