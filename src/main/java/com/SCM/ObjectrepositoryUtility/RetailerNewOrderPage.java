package com.SCM.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerNewOrderPage {
	WebDriver driver=null;

	public RetailerNewOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public WebElement getNewOrderLink() {
		return newOrderLink;
	}

	public WebElement getQuantityEdit() {
		return quantityEdit;
	}

	public WebElement getPostorderBtn() {
		return postorderBtn;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	@FindBy(xpath = "//a[text()='New Order']")
	private WebElement newOrderLink;
	
	@FindBy(id = "1")
	private WebElement quantityEdit;
	
	@FindBy(id = "btnSubmit")
	private WebElement postorderBtn;
	
	@FindBy(xpath = "//input[@class='submit_button' and @value='Log out' and @style='float:right;margin:10px;']")
	private WebElement logoutButton;
	
	public void newOrder(String qTy)
	{
		getNewOrderLink().click();
		quantityEdit.sendKeys(qTy);

	}

		
	}

