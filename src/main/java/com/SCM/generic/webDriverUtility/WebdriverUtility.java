package com.SCM.generic.webDriverUtility;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	// maximize window1
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	// Minimize window2
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	// implicitly wait3
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	// explicit wait for element present4
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// explicit wait for ElementTobeClickable5
	public void waitForElementTobeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// switch to window url6
	public void SwitchToTabToURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();// iterator point to set
		while (it.hasNext())// if we want to capture the data from set collection w have one mtd hasNext()
		{
			String windowID = it.next();
			driver.switchTo().window(windowID);// switch the 1stwindow wherever itis
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partialURL)) {
				break;
			}
		}
	}

	public void SwitchToTabUrl(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		for (String win : set) {
			driver.switchTo().window(win);
			if (driver.getCurrentUrl().equals(partialURL))
				break;
		}

	}

	// switch to window title7
	public void SwitchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();// iterator point to set
		while (it.hasNext())// if we want to capture the data from set collection w have one mtd hasNext()
		{
			String windowID = it.next();
			driver.switchTo().window(windowID);// switch the 1stwindow wherever itis
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partialTitle)) {
				break;
			}
		}
	}

	// switch to frame index8
	public void switchToFrame(WebDriver driver, int Index) {
		driver.switchTo().frame(Index);
	}

	// switch to frame element9
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	// switch to frame nameId10
	public void switchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}

	// switch to alert accept11
	public void switchToAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	// switch to alert dismiss12
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	// select class visible text13
	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	// select class by index14
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	// select class by visible value15
	public void select(String value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}

	// Movetoelement16
	public void moveOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		act.click(element).perform();
	}

	// doubleclick17
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	// rightclick18
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	// take screenshot19
	public void screenshotForWebPage(WebDriver driver, String tcName) throws Throwable {
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot eDriver = (TakesScreenshot) driver;
		String filepath = eDriver.getScreenshotAs(OutputType.BASE64);
		File dst = new File("./Screenshots/" + tcName + "_" + time + ".png");
		// FileHandler.copy(srs, dst);
	}

	// take screenshot20
	public void screenshotForElement(WebElement element, String tcName) throws Throwable {
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		File srs = element.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshots/" + tcName + "+" + time + ".png");
		FileHandler.copy(srs, dst);
	}

	// select==getoptions 21
	public List getAllOption(WebElement element) {
		Select sel = new Select(element);
		List<WebElement> allOptn = sel.getOptions();
		return allOptn;
	}
	
	public void scrollToele(WebDriver driver,WebElement ele) {
		Actions act=new Actions(driver);
		act.scrollToElement(ele).perform();
	}
	
	public void scrollByAmount(WebDriver driver,int index)
	{
		Actions act=new Actions(driver);
		act.scrollByAmount(0, 500);
	}
	// dragAndDrop 22
	public void dragAndDrop(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.dragAndDrop(element, element).perform();
	}

	// Quit window23
	public void close(WebDriver driver) {
		driver.quit();
	}

	//
}
