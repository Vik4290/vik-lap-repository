package mvn_demo;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestNg_Demo {

public static Logger log = Logger.getLogger("devpinoyLogger");

	@Test
	public void testmethod1()
	{
		System.out.println("Inside Test Method1");
		log.debug("Test Method 1 Passed");
	}
	@Test
	public void testmethod2()
	{
		System.out.println("Inside Test Method2");
		log.debug("Test Method 2 Passed");
	}
	@BeforeMethod
	public void Beforemethod()
	{
		System.out.println("Inside Before Method");
		log.debug("Before Method Passed");
	}
	@AfterMethod
	public void Aftermethod()
	{
		System.out.println("Inside After Method");
		log.debug("After Method Passed");
	}
	@org.testng.annotations.BeforeClass
	public void BeforeClass()
	{
		System.out.println("Inside Before Class");
		log.debug("Before Class Passed");
		//PropertyConfigurator.configure("C:\\Users\\Vikram\\eclipse-workspace\\Demo_Project\\src\\log4j.properties");
	}
	@org.testng.annotations.AfterClass
	public void AfterClass()
	{
		System.out.println("Inside After Class");
		log.debug("After Class Passed");
	}
	@org.testng.annotations.BeforeTest
	public void BeforeTest()
	{
		System.out.println("Inside Before Test");
		log.debug("Before Test Passed");
	}
	@org.testng.annotations.AfterTest
	public void AfterTest()
	{
		System.out.println("Inside After Test");
		log.debug("After Test Passed");
	}
	
}
