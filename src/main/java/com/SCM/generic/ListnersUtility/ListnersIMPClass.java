package com.SCM.generic.ListnersUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.comcast.crm.baseTest.BaseClass;
//import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListnersIMPClass implements ITestListener,ISuiteListener {
	public static ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;
	
	public void onStart(ISuite suite) {
		System.out.println("Report config");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		
		spark.config().setDocumentTitle("SCM testSuite Result");
		spark.config().setReportName("SCM Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows10");
		report.setSystemInfo("Browser", "CHROME-100");	
	}

	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Start test");
		System.out.println("===" + result.getMethod().getMethodName() + "==START==");
		test = report.createTest(result.getMethod().getMethodName());
		//UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "===>Test is started<===");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("End test");
		System.out.println("===" + result.getMethod().getMethodName() + "==END==");
		test.log(Status.INFO, result.getMethod().getMethodName() + "===>Test is completd<===");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("TC FAILED");
		String testName = result.getMethod().getMethodName();
		//TakesScreenshot eDriver = (TakesScreenshot) BaseClass.sdriver;
		//String filepath = eDriver.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "_").replace(":", "_");// time stamp
		//test.addScreenCaptureFromBase64String(filepath, testName + "_" + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "===>FAILED<===");
		test.log(Status.FAIL, result.getThrowable() + "===>FAILED<===");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("TC SKIPPED");
		test.log(Status.FAIL, result.getMethod().getMethodName() + "===>Skipped<===");
		test.log(Status.FAIL, result.getThrowable() + "===>Skipped<===");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("TC FAILED percentage");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("TC FAILED timeout");
	}	

	public void onStart(ITestContext context) {
		System.out.println("onStart");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
	}

}
