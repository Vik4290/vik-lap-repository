
package com.zom.pom.pages;

import org.openqa.selenium.By;

import com.zom.pom.base.Page;
import com.zom.pom.pages.LoginPage.LogInPage;

public class HomePage extends Page{

	public void gotoCustomers()
	{
		
	}
	
	
	public void gotoSupport()
	{
		//driver.findElement(By.xpath("//a[@class='zh-support']")).click();
		click("support_XPATH");
	}
	
	
	public void gotoContactSales()
	{
		
	}
	
	
	public LogInPage gotoLogIn()
	{
		//driver.findElement(By.xpath("//a[@class='zh-login']")).click();
	    click("gotoLogin_XPATH");
	    log.debug("Navigate to LogIn Page");
		return new LogInPage();
	}
	
	
	public void gotoFreeSignup()
	{
		
	}
	
}
