package com.SCM.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SCM.generic.webDriverUtility.WebdriverUtility;

public class AdminAddProductPage {
	WebDriver driver;

	public AdminAddProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Add Products']")
	private WebElement addproductLink;

	@FindBy(id = "product:name")
	private WebElement productNameEdit;

	@FindBy(id = "product:price")
	private WebElement priceEdit;

	@FindBy(id = "product:unit")
	private WebElement unitTypeDropDown;

	@FindBy(id = "product:category")
	private WebElement categoryDropdown;

	@FindBy(xpath = "//li[5]//input[@type='radio'and @value='1']")
	private WebElement enableRadioButton;

	@FindBy(xpath = "//li[5]//input[@type='radio'and @value='2']")
	private WebElement disableRadioButton;

	@FindBy(id = "product:description")
	private WebElement discriptionEdit;

	@FindBy(xpath = "//input[@class='submit_button' and @value='Add Product']")
	private WebElement addproductButton;

	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logoutButton;

	public WebElement getAddproductLink() {
		return addproductLink;
	}

	public WebElement getProductNameEdit() {
		return productNameEdit;
	}

	public WebElement getPriceEdit() {
		return priceEdit;
	}

	public WebElement getUnitTypeDropDown() {
		return unitTypeDropDown;
	}

	public WebElement getCategoryDropdown() {
		return categoryDropdown;
	}

	public WebElement getEnableRadioButton() {
		return enableRadioButton;
	}

	public WebElement getDisableRadioButton() {
		return disableRadioButton;
	}

	public WebElement getDiscriptionEdit() {
		return discriptionEdit;
	}

	public WebElement getAddproductButton() {
		return addproductButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public void addOneProduct(String productName, String price, String unitType, String category, String description)
			throws InterruptedException {
		Thread.sleep(2000);
		WebdriverUtility wLib = new WebdriverUtility();
		wLib.waitForPageToLoad(driver);
		
		productNameEdit.sendKeys(productName);
		priceEdit.sendKeys(price);

		wLib.select(unitType, unitTypeDropDown);
		wLib.select(category, categoryDropdown);
		enableRadioButton.click();
		discriptionEdit.sendKeys(description);
		Thread.sleep(4000);
	}
	
}
