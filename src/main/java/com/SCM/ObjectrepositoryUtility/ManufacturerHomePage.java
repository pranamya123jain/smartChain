package com.SCM.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturerHomePage {
	WebDriver driver=null;

	public ManufacturerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//a[text()='Orders']")
	private WebElement ordersLink;
	
	@FindBy(xpath = "//td[text()=' 22-11-2024 ']/following-sibling::td/a[text()='Confirm']")
	private WebElement confirmLink;

	public WebElement getOrdersLink() {
		return ordersLink;
	}

	public WebElement getConfirmLink() {
		return confirmLink;
	}
	
	
	
}
