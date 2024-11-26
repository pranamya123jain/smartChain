package com.SCM.ObjectrepositoryUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SCM.generic.webDriverUtility.WebdriverUtility;

public class ManageUnitPage {
	WebDriver driver=null;
	public ManageUnitPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(xpath = "//a[text()='Manage Unit']")
	private WebElement manageUnitLink;
	
	@FindBy(xpath = "//input[@class='submit_button' and @type='button' and @value='+ Add Unit']")
	private WebElement addUnitBtn;
	
	@FindBy(id = "unitName")
	private WebElement unitNameEdit;
	
	@FindBy(xpath = "//input[@value='Add Unit']")
	private WebElement addUnitBtn1;
	
	public WebElement getManageUnitLink() {
		return manageUnitLink;
	}

	public WebElement getAddUnitBtn() {
		return addUnitBtn;
	}

	public WebElement getUnitNameEdit() {
		return unitNameEdit;
	}

	public WebElement getAddUnitBtn1() {
		return addUnitBtn1;
	}
	
	public void addUnit()
	{
		manageUnitLink.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		addUnitBtn.click();
		
	}
	public void addOneUnit(String addUnit)
	{
		unitNameEdit.sendKeys(addUnit);
		addUnitBtn1.click();
		WebdriverUtility wLib=new WebdriverUtility();
		wLib.switchToAlert(driver);
	}
}
