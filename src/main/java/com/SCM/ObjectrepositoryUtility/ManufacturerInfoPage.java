package com.SCM.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturerInfoPage {
	WebDriver driver=null;

	public ManufacturerInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
}
	@FindBy (xpath = "//a[text()='Products']")
	private WebElement ProductsLink;
	
	@FindBy (xpath = "//table[@class='table_displayData']/tbody/tr[last()]/td[last()-2]")
	private WebElement ProductsCheck;

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getProductsCheck() {
		return ProductsCheck;
	}
	
	

}
