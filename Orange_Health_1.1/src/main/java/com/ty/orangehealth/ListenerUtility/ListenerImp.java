package com.ty.orangehealth.ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ty.orangehealth.Generic_Utility.ThreadSafeClass;
import com.ty.orangehealth.business_utility.BaseClassTest;



public class ListenerImp implements ITestListener,ISuiteListener{
	public ExtentReports report;
	public static ExtentTest test;
  public void onStart(ISuite suit) {
	  
	  String time=new Date().toString().replace(" ", " _");
	  ExtentSparkReporter spark=new ExtentSparkReporter("./Advanced_Report./orangehealth"+time+".html");
	  spark.config().setDocumentTitle("health");
	  spark.config().setReportName("healthReport");
	  spark.config().setTheme(Theme.DARK);
	  
	  report=new ExtentReports();
	  report.attachReporter(spark);
	  report.setSystemInfo("os", "windows");
	  report.setSystemInfo("browser", "chrome");  
  }
  public void onFinish(ISuite suite) {
	  System.out.println("Report BackUp");
	  report.flush();
	  
  }
  public void OnTestStart(ITestResult result) {
		System.out.println("====="+result.getMethod().getMethodName()+"====START=====");
		test=report.createTest(result.getMethod().getMethodName());
		ThreadSafeClass.setTest(test);
		ThreadSafeClass.getTest().log(Status.INFO, "Test Case got started");  
  }
  public void onTestFailure(ITestResult result) {
	    ThreadSafeClass.getTest().log(Status.FAIL, "Status got failed");
		String testName = result.getMethod().getMethodName();
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot tks=(TakesScreenshot)BaseClassTest.sdriver;
		String src = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(src,testName+" "+time);
}
	public void onTestSuccess(ITestResult result) {
		System.out.println("====="+result.getMethod().getMethodName()+"====END=====");
      test.log(Status.PASS, "Test Case got Pass");
}
  
}
