package adminTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SCM.Basetest.BaseclassTest;
import com.SCM.ObjectrepositoryUtility.AdminAddManufacturerPage;
import com.SCM.ObjectrepositoryUtility.AdminAddProductPage;
import com.SCM.ObjectrepositoryUtility.AdminInfoPage;
import com.SCM.ObjectrepositoryUtility.LoginPage;
import com.SCM.ObjectrepositoryUtility.RetailerHomePage;
import com.SCM.ObjectrepositoryUtility.RetailerInfoPage;
import com.SCM.generic.fileUtility.FileUtility;
import com.SCM.generic.webDriverUtility.WebdriverUtility;

public class AddProductAdminTest extends BaseclassTest {
	
@Test(groups = {"regression test"})
public void addproductAdminRetailerTest() throws Throwable {
	String type;
	String productName = eLib.getDtaFromExcel("Product", 1, 0);
	String price = eLib.getDtaFromExcel("Product", 1, 1);
	String unitType= eLib.getDtaFromExcel("Product", 1, 2);
	String category = eLib.getDtaFromExcel("Product", 1, 3);
	String description = eLib.getDtaFromExcel("Product", 1, 4);
	
	FileUtility fLib = new FileUtility();
	String adminUSERNAME = fLib.getDataFromPropertyFile("adminusername");
	String adminPASSWORD = fLib.getDataFromPropertyFile("adminpassword");
	type = fLib.getDataFromPropertyFile("admintype");
	
	LoginPage lp = new LoginPage(driver);
	lp.login(adminUSERNAME, adminPASSWORD, type);
	
	AdminAddProductPage aap=new AdminAddProductPage(driver);
	System.out.println(aap.getAddproductLink());
	aap.getAddproductLink().click();
	aap.addOneProduct(productName, price, unitType, category, description);
	Thread.sleep(2000);

	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 1000)");
	aap.getAddproductButton().click();
	
	Thread.sleep(2000);
	WebdriverUtility wLib = new WebdriverUtility();
	wLib.switchToAlert(driver);
	Thread.sleep(4000);
	AdminAddManufacturerPage aam=new AdminAddManufacturerPage(driver);
	
	AdminInfoPage aIp=new AdminInfoPage(driver);
	aIp.getProductsLink().click();
	String actProduct=aIp.getProductsCheck().getText();
	boolean result = actProduct.contains(productName);
	Assert.assertEquals(result, true);
	
	aam.logoutAdmin();
	
	String retailerUSERNAME = fLib.getDataFromPropertyFile("retailerusername");
	String retailerpassword = fLib.getDataFromPropertyFile("retailerpassword");
	type = fLib.getDataFromPropertyFile("retailertype");
	lp.login(retailerUSERNAME, retailerpassword, type);
	
	RetailerHomePage rHp=new RetailerHomePage(driver);
	rHp.getProductLink().click();
	 js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	 
	 /*validate as retailer*/
	 RetailerInfoPage rIp=new RetailerInfoPage(driver);
	 rIp.getProductsLink().click();
		String actProduct1=aIp.getProductsCheck().getText();
		boolean result1 = actProduct1.contains(productName);
		Assert.assertEquals(result1, true);

	//aam.logoutAdmin();
}
}