package manufacturerTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SCM.Basetest.BaseclassTest;
import com.SCM.ObjectrepositoryUtility.AdminAddManufacturerPage;
import com.SCM.ObjectrepositoryUtility.AdminAddProductPage;
import com.SCM.ObjectrepositoryUtility.AdminInfoPage;
import com.SCM.ObjectrepositoryUtility.LoginPage;
import com.SCM.ObjectrepositoryUtility.ManufacturerInfoPage;
import com.SCM.generic.fileUtility.FileUtility;
import com.SCM.generic.webDriverUtility.WebdriverUtility;

public class AddProductManufacturerTest extends BaseclassTest {
	@Test(groups = {"regression test"})
	public void addProductManufacturerTest() throws Throwable {
		String type;
		String productName = eLib.getDtaFromExcel("Product", 1, 0);
		String price = eLib.getDtaFromExcel("Product", 1, 1);
		String unitType= eLib.getDtaFromExcel("Product", 1, 2);
		String category = eLib.getDtaFromExcel("Product", 1, 3);
		String description = eLib.getDtaFromExcel("Product", 1, 4);
		
		FileUtility fLib = new FileUtility();
		String manufacturerUSERNAME = fLib.getDataFromPropertyFile("manufactureruser");
		String manufacturepassword = fLib.getDataFromPropertyFile("manufacturerpassword");
		type = fLib.getDataFromPropertyFile("manufacturertype");
		
		/*login as manufacturer*/
		LoginPage lp = new LoginPage(driver);
		lp.login(manufacturerUSERNAME, manufacturepassword, type);
		
		/*add product as manufacturer*/
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
		
		ManufacturerInfoPage mIp=new ManufacturerInfoPage(driver);
		mIp.getProductsLink().click();
		String actProduct=mIp.getProductsCheck().getText();
		boolean result = actProduct.contains(productName);
		Assert.assertEquals(result, true);
		
		/*logout as manufacturer*/
		AdminAddManufacturerPage aam=new AdminAddManufacturerPage(driver);
		aam.logoutAdmin();

		
		
		
		
}
}