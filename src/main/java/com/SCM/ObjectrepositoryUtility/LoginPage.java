package com.SCM.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SCM.Basetest.BaseclassTest;
import com.SCM.generic.webDriverUtility.WebdriverUtility;

public class LoginPage extends BaseclassTest {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login:username")
	private WebElement userNameEdit;
	
	@FindBy(id="login:password")
	private WebElement passwordEdit;
	
	@FindBy(id="login:type")
	private WebElement loginTypeDropdown;
	
	@FindBy(xpath = "//input[@class='submit_button']")
	private WebElement loginButton;

	
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginTypeDropdown() {
		return loginTypeDropdown;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void login(String USERNAME,String PASSWORD,String type)
	{	
		userNameEdit.sendKeys(USERNAME);
		passwordEdit.sendKeys(PASSWORD);
		WebdriverUtility wLib=new WebdriverUtility();
		wLib.select(type, loginTypeDropdown);
		loginButton.click();
	}
	
}
