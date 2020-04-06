package com.zom.pom.pages.Landing;

import org.openqa.selenium.By;

import com.zom.pom.base.Page;
import com.zom.pom.pages.Landing.CRM.CRM;

public class LandingPage extends Page{

	
	public void verifyLandingPage()
	{
		
		//if(driver.findElement(By.xpath("//div[@class='app-nm'][text()='CRM']")).isDisplayed())
		if(isdisplayed("verifyLanding_XPATH"))
		{
			System.out.println("Landed Successfully");
			log.debug("Landed Successfully-debug message");
		}
		
	
	}
		

	public CRM gotoCRM()
	{
		//driver.findElement(By.xpath("//div[@class='app-nm'][text()='CRM']")).click();
		click("gotoCRM_XPATH");
		return new CRM();
	}	
		
	
	public void gotoBook()
	{
		
	}
	
	public void gotoCalendar()
	{
		
	}
	
	public void gotoCampaigns()
	{
		
	}
	
	public void gotoCliq()
	{
		
	}
	
	public void gotoConnections()
	{
		
	}
	
	
	public void gotoDesk()
	{
		
	}
	
	public void gotoInvoice()
	{
		
	}
	
	
	
	
	
}
