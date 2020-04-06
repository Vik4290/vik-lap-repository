package com.zom.pom.rough.Testcase;

import java.io.File;
import java.util.Date;

import org.testng.annotations.AfterSuite;

import com.zom.pom.base.Page;

public class BaseTestinitialize {
	
	public void setup() {
		
		
	}

	@AfterSuite
	public void quit()
	{
		//Page.driver.quit();
/*		
		Date date = new Date();
		String filePathdate = date.toString().replace(":", "_").replace(" ", "_");
		
		String filename = "index.html";
		//System.getProperty("user.dir")+"\\reports\\"+fileName
	
		String actualReportPath = System.getProperty("user.dir") + "\\reports\\" + filename;
		
				new File(actualReportPath).renameTo(new File(System.getProperty("user.dir") + "\\reports\\" + "Extent_Report" +"-" + filePathdate + ".html"));

	*/
	}
	
	
	
}
