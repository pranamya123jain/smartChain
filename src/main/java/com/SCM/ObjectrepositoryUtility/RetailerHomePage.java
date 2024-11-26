package com.SCM.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerHomePage {
		WebDriver driver=null;
		public RetailerHomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}
		@FindBy (xpath = "//a[text()='Products']")
		private WebElement productLink;
		
		
		public WebElement getProductLink() {
			return productLink;
		}
		
}
