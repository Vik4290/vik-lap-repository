package com.zom.pom.pages.LoginPage;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.zom.pom.base.Page;
import com.zom.pom.pages.Landing.LandingPage;

public class LogInPage extends Page {

	public LandingPage loginSuccessfully() throws Exception
	{
		driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys("vik.bakshi@hotmail.com");
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("tuktuk@123");
		Thread.sleep(5000);
		//Assert.fail("Failing it intentionally");
		//driver.findElement(By.xpath("//button[@id='nextbtn']/child::span")).click();
		//return new LandingPage();
	throw new Exception();
	}
	
	
	public void gotoForgotPassword()
	{
		driver.findElement(By.xpath("//div[@id='enableforgot']/child::span")).click();
	}
	
	
	
}
