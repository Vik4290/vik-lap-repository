package com.zom.pom.Utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.zom.pom.base.Page;


public class Utilities extends Page 
{

	public static String screenshotPath;
	public static String screenshotName;

	public static String captureScreenshot() throws IOException {

	
		
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";


File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

String encodedBase64 = null;

FileInputStream fileInputStreamReader = null;
try {
fileInputStreamReader = new FileInputStream(sourceFile);
byte[] bytes = new byte[(int)sourceFile.length()];
fileInputStreamReader.read(bytes);
encodedBase64 = new String(Base64.encodeBase64(bytes));

       /* String screenShotDestination = createScreeshotFolderStructure()+"/"+
                imageName.trim().replace(" ","_") + ".png";

        File destination = new File(screenShotDestination);
        FileUtils.copyFile(sourceFile, destination);
*/
FileUtils.copyFile(sourceFile,new File(System.getProperty("user.dir") + "/reports/screenshots/" + screenshotName));

    } catch (IOException e) {
        e.printStackTrace();
    }
    return "data:image/png;base64,"+encodedBase64;
		
		
		
		/*	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		FileUtils.copyFile(scrFile,
				
		new File(System.getProperty("user.dir") + "/reports/" + screenshotName));
		//screenshotPath= System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName;
	*/
		
	}

	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}
	
	
	public static boolean isTestRunnable(String testName, ExcelReader excel){
		
		String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);
		
		
		for(int rNum=2; rNum<=rows; rNum++){
			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(testName)){
				
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
			
			
		}
		return false;
	}
	
}
