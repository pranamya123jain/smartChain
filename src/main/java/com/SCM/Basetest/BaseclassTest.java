package com.SCM.Basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.SCM.generic.fileUtility.ExcelUtility;
import com.SCM.generic.fileUtility.FileUtility;
import com.SCM.generic.webDriverUtility.JavaUtility;
import com.SCM.generic.webDriverUtility.WebdriverUtility;

public class BaseclassTest {
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	WebdriverUtility wLib = new WebdriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(alwaysRun = true)
	public void BSconfigTest() {
		System.out.println("Connect to DB");
	}

	@BeforeClass(alwaysRun = true)
	public void BCconfigTest() throws Throwable {
		System.out.println("Launch the browser");
		String Browser = fLib.getDataFromPropertyFile("browser");
		// String Browser=browser;
		if (Browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
	}

	@BeforeMethod(alwaysRun = true)
	public void BMconfigTest() throws Throwable {
		System.out.println("Login to appln");
		driver.manage().window().maximize();
		String URL = fLib.getDataFromPropertyFile("url");
		driver.get(URL);
		wLib.waitForPageToLoad(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void AMconfigTest() {
		System.out.println("Logout from appln");
//		AdminAddManufacturer aam=new AdminAddManufacturer(driver);
//		aam.logoutAdmin();
	}

	@AfterClass(alwaysRun = true)
	public void ACconfigTest() {
		System.out.println("Close the browser");
	//	driver.close();
		
	}

	@AfterSuite(alwaysRun = true)
	public void ASconfigTest() {
		System.out.println("Close DB connection");
	}
}
