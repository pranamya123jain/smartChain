package adminTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SCM.Basetest.BaseclassTest;
import com.SCM.ObjectrepositoryUtility.AdminAddManufacturerPage;
import com.SCM.ObjectrepositoryUtility.AdminAddProductPage;
import com.SCM.ObjectrepositoryUtility.AdminInfoPage;
import com.SCM.ObjectrepositoryUtility.LoginPage;
import com.SCM.ObjectrepositoryUtility.ManageUnitPage;
import com.SCM.ObjectrepositoryUtility.ManufacturerInfoPage;
import com.SCM.generic.fileUtility.FileUtility;
import com.SCM.generic.webDriverUtility.WebdriverUtility;

public class CreateManufacturer_AddUnit extends BaseclassTest {
	@Test(groups = {"smoke test"})
	public void addManufacturertest() throws Throwable {
		/*add manufacturer*/
		String name = eLib.getDtaFromExcel("Manufacturer", 1, 0);
		String email = eLib.getDtaFromExcel("Manufacturer", 1, 1);
		String phone = eLib.getDtaFromExcel("Manufacturer", 1, 2);
		String userName = eLib.getDtaFromExcel("Manufacturer", 1, 3);
		String password = eLib.getDtaFromExcel("Manufacturer", 1, 4);

		FileUtility fLib = new FileUtility();
		String adminUSERNAME = fLib.getDataFromPropertyFile("adminusername");
		String adminPASSWORD = fLib.getDataFromPropertyFile("adminpassword");
		String type = fLib.getDataFromPropertyFile("admintype");
		LoginPage lp = new LoginPage(driver);
		lp.login(adminUSERNAME, adminPASSWORD, type);

		AdminAddManufacturerPage aam = new AdminAddManufacturerPage(driver);
		aam.addManufacturer(name, email, phone, userName, password);
		
		AdminInfoPage aIp=new AdminInfoPage(driver);
		String actMunucature=aIp.getManufacturersCheck().getText();
		boolean result = actMunucature.contains(name);
		Assert.assertEquals(result, true);
}
	@Test(groups = {"regression test"})
	public void addManufacturer_Login_AddUnit_test() throws Throwable {
		/*add manufacturer*/
		String name = eLib.getDtaFromExcel("Manufacturer", 1, 0);
		String email = eLib.getDtaFromExcel("Manufacturer", 1, 1);
		String phone = eLib.getDtaFromExcel("Manufacturer", 1, 2);
		String userName = eLib.getDtaFromExcel("Manufacturer", 1, 3);
		String password = eLib.getDtaFromExcel("Manufacturer", 1, 4);
		String addUnit = eLib.getDtaFromExcel("AddUnit", 1, 0);
		
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

		AdminAddManufacturerPage aam = new AdminAddManufacturerPage(driver);
		aam.addManufacturer(name, email, phone, userName, password);
		aam.logoutAdmin();
		
		/*login as Manufacturer*/
		String manufacturerUSERNAME = fLib.getDataFromPropertyFile("manufactureruser");
		String manufacturepassword = fLib.getDataFromPropertyFile("manufacturerpassword");
		type = fLib.getDataFromPropertyFile("manufacturertype");
		lp.login(manufacturerUSERNAME, manufacturepassword, type);
		
		/*Manufacturer add unit*/
		ManageUnitPage mUp=new ManageUnitPage(driver);
		mUp.addUnit();
		mUp.addOneUnit(addUnit);
		
		
		/*add product as manufacturer*/
		AdminAddProductPage aap=new AdminAddProductPage(driver);
		System.out.println(aap.getAddproductLink());
		aap.getAddproductLink().click();
		aap.addOneProduct(productName, price, unitType, category, description);
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 1000)");
		aap.getAddproductButton().click();
		WebdriverUtility wLib=new WebdriverUtility();
		wLib.switchToAlert(driver);
		
		/*validate product as manufacturer*/
		ManufacturerInfoPage mIp=new ManufacturerInfoPage(driver);
		mIp.getProductsLink().click();
		String actProduct=mIp.getProductsCheck().getText();
		boolean result = actProduct.contains(productName);
		Assert.assertEquals(result, true);
		
		
}
}
