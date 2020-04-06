package com.zom.pom.pages.Landing.CRM;

import org.openqa.selenium.By;


import com.zom.pom.base.Page;

public class CRM extends Page
{

	public void CRMconfirmpage()
	{
		String s = driver.findElement(By.xpath("//span[@id='show-uName']")).getText();
		
		if(s=="Welcome vik.bakshi")
		{

			System.out.println("Landed on CRM page successfully");	
		}
		else
		{
			System.out.println("Not Landed on CRM successfully");
		}
		
	}
	
	public void TermsofService()
	{
		
		
	}
}
