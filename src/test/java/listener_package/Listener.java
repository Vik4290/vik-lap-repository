package listener_package;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener
{

	 public void onTestFailure(ITestResult result)
	 {
		 System.out.println("Testcase Fail");
	 System.out.println(result.getTestName());
	 System.out.println(result.getName());
	 }
	 
	 public void onTestSuccess(ITestResult result) 
	 {
		 System.out.println("Testcase Passed");
		 System.out.println(result.getTestName());
		 System.out.println(result.getName());
	 }

	 
	

}
