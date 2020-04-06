package com.zom.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenu extends Page {

	WebDriver driver;
	
	public TopMenu(WebDriver driver){
		
		this.driver = driver;
	}
	
	public void Home()
	{
		
	}
	
	public void Leads()
	{
		
	}
	
	public void Contacts()
	{
		
	}

	public void Accounts()
	{
		
	}
	
	public void Signout()
	{
		driver.findElement(By.xpath("//img[@id='topdivuserphoto_118794000000124001']")).click();
		driver.findElement(By.xpath("//a[@data-zcqa='signOut']")).click();
		
		
		
	}
	
}
