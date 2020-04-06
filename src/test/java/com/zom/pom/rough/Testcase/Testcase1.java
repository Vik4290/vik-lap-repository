package com.zom.pom.rough.Testcase;


import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.zom.pom.base.Page;
import com.zom.pom.pages.HomePage;
import com.zom.pom.pages.Landing.LandingPage;
import com.zom.pom.pages.Landing.CRM.CRM;
import com.zom.pom.pages.LoginPage.LogInPage;

public class Testcase1 {
	
	@Test
	public void test1() throws Exception
	{
		HomePage hp=new HomePage();
		LogInPage lp =  hp.gotoLogIn();
		Page.log.debug("Inside Test1 Testcase");
		
		LandingPage  lpp= lp.loginSuccessfully();
		lpp.verifyLandingPage();
		 
		 CRM crm =lpp.gotoCRM();
		 crm.CRMconfirmpage();
		 Page.menu.Signout();
			
	}
	
	@AfterTest
	public void tearDown()
	{
		Page.driver.quit();
	}
	
	

}
