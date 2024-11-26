package com.SCM.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SCM.generic.webDriverUtility.WebdriverUtility;

public class AdminAddManufacturerPage {
	WebDriver driver=null;

	public AdminAddManufacturerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
}
	@FindBy(xpath = "//a[text()='Add Manufacturer']")
	private WebElement addManufacturerLink;
	
	@FindBy(id="manufacturer:name")
	private WebElement nameEdit;
	
	@FindBy(id="manufacturer:email")
	private WebElement emailEdit;
	
	@FindBy(id="manufacturer:phone")
	private WebElement phoneEdit;
	
	@FindBy(id="manufacturer:username")
	private WebElement userNameEdit;
	
	@FindBy(id="manufacturer:password")
	private WebElement passwordEdit;
	
	@FindBy(xpath="//input[@value='Add Manufacturer']")
	private WebElement addManufacturerButton;
	
	@FindBy(xpath = "//a[text()='Manufacturers']")
	private WebElement manufacturerLink;
	
	public WebElement getManufacturerLink() {
		return manufacturerLink;
	}
	@FindBy(xpath = "//input[@class='submit_button' and @value='Log out' and @style='float:right;margin:10px;']")
	private WebElement logoutButton;

	public WebElement getAddManufacturerLink() {
		return addManufacturerLink;
	}

	public WebElement getNameEdit() {
		return nameEdit;
	}

	public WebElement getEmailEdit() {
		return emailEdit;
	}

	public WebElement getPhoneEdit() {
		return phoneEdit;
	}

	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getAddManufacturerButton() {
		return addManufacturerButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	public void addManufacturer(String name,String email,String phone,String userName,String password) throws InterruptedException
	{
		addManufacturerLink.click();
		nameEdit.sendKeys(name);
		emailEdit.sendKeys(email);
		phoneEdit.sendKeys(phone);
		userNameEdit.sendKeys(userName);
		passwordEdit.sendKeys(password);
		
		WebdriverUtility wLib=new WebdriverUtility();
		Thread.sleep(2000);
		wLib.scrollToele(driver,addManufacturerButton);
		addManufacturerButton.click();
		Thread.sleep(2000);
		wLib.switchToAlert(driver);
		manufacturerLink.click();
		
	}
	public void logoutAdmin()
	{
		logoutButton.click();
	}
}