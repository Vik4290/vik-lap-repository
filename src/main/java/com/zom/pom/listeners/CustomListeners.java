package com.zom.pom.listeners;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

//import com.relevantcodes.extentreports.LogStatus;
import com.zom.pom.base.Page;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.zom.pom.Utilites.MonitoringMail;
import com.zom.pom.Utilites.TestConfig;
import com.zom.pom.Utilites.Utilities;

public class CustomListeners extends Page implements ITestListener,ISuiteListener {

	public 	String messageBody;
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
		}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {

		//***************Done with my code
		
		
		//******************************TestNg report
		System.setProperty("org.uncommons.reportng.escape-output","false");
		
		String excepionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
		
		try {

		/*	Utilities.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(Utilities.screenshotName)
							.build());
		*/
			
			Utilities.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir") + "../reports/screenshots/" + Utilities.screenshotName)
							.build());
		
			
		} 
		catch (IOException e) {

		}
		
		String failureLogg="TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);
		
		//************Logs for ReportNg
/*				
		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+" height=200 width=200></img></a>");
	*/	
		//rep.endTest(test);
		rep.flush();
		
	}


	public void onTestFailure(Exception e) {

		//***************Done with my code
		
			
		try {

			Utilities.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(Utilities.screenshotName)
							.build());

			
		} 
		catch (IOException ex) {

		}
		
		String failureLogg="TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);
		
		rep.flush();
		
	}

	public void onTestSkipped(ITestResult result) {

		//Done with my code
		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);
		
	}


	public void onTestStart(ITestResult result) {

		//***********Done with my code
		test = rep.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
        testReport.set(test);
		
			
	}
	
	public void onTestSuccess(ITestResult result) {

		//***********Done with my code
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);
	
	}

	public void onFinish(ISuite arg0) {
		
		if (extent != null) {

			extent.flush();
	/*
			Date date = new Date();
			String filePathdate = date.toString().replace(":", "_").replace(" ", "_");
			
			String filename = "index.html";
			//System.getProperty("user.dir")+"\\reports\\"+fileName
		
			String actualReportPath = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + filename;
			
					new File(actualReportPath).renameTo(new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + "Extent_Report" +"-" + filePathdate + ".html"));
	*/
	/*	
		MonitoringMail mail = new MonitoringMail();
		 
		try {
			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/LiveProject%20-%20PageObjectModel/Extent_Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		}
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

}
