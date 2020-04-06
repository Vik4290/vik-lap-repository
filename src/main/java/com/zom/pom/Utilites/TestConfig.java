package com.zom.pom.Utilites;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestConfig{

//Mailing detail
	

	public static String v = datetime();
	  
	   
	public static String server="smtp.gmail.com";
	public static String from = "vikbaksh@gmail.com";
	public static String password = "Nokia@6630";
	public static String[] to ={"vikrambakshiynr@gmail.com","vik.bakshi@hotmail"};
	public static String subject = "Extent Project Report-Vikram"+"--" +v;
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath="C:\\Users\\Vikram\\eclipse-workspace\\Demo_extent_report\\target\\surefire-reports\\emailable-report.html";
	public static String attachmentName="emailable-report.html";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/acs";
	
	
	
	
	
	public static String datetime()
	{
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now();  
	String v = dtf.format(now);
	return v;
	}
	
	
	
	
	
	
}
