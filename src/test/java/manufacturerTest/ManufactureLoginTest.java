package manufacturerTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SCM.Basetest.BaseclassTest;
import com.SCM.ObjectrepositoryUtility.AdminAddManufacturerPage;
import com.SCM.ObjectrepositoryUtility.AdminAddProductPage;
import com.SCM.ObjectrepositoryUtility.AdminHomePage;
import com.SCM.ObjectrepositoryUtility.AdminInfoPage;
import com.SCM.ObjectrepositoryUtility.LoginPage;
import com.SCM.ObjectrepositoryUtility.ManufacturerInfoPage;
import com.SCM.generic.fileUtility.FileUtility;
import com.SCM.generic.webDriverUtility.WebdriverUtility;

public class ManufactureLoginTest extends BaseclassTest {
	@Test(groups = {"regression test"})
	public void loginManufacturer() throws Throwable {
		String type;
		String productName = eLib.getDtaFromExcel("Product", 1, 0);
		String price = eLib.getDtaFromExcel("Product", 1, 1);
		String unitType = eLib.getDtaFromExcel("Product", 1, 2);
		String category = eLib.getDtaFromExcel("Product", 1, 3);
		String description = eLib.getDtaFromExcel("Product", 1, 4);

		/* login as manufacturer */
		FileUtility fLib = new FileUtility();
		String manufacturerUSERNAME = fLib.getDataFromPropertyFile("manufactureruser");
		String manufacturepassword = fLib.getDataFromPropertyFile("manufacturerpassword");
		type = fLib.getDataFromPropertyFile("manufacturertype");
		LoginPage lp = new LoginPage(driver);
		lp.login(manufacturerUSERNAME, manufacturepassword, type);

		/* add product as manufacturer */
		AdminAddProductPage aap = new AdminAddProductPage(driver);
		System.out.println(aap.getAddproductLink());
		aap.getAddproductLink().click();
		aap.addOneProduct(productName, price, unitType, category, description);
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)");
		aap.getAddproductButton().click();
		
		/*validate Product*/
		ManufacturerInfoPage mIp=new ManufacturerInfoPage(driver);
		mIp.getProductsLink().click();
		String actProduct=mIp.getProductsCheck().getText();
		boolean result = actProduct.contains(productName);
		Assert.assertEquals(result, true);

		Thread.sleep(2000);
		WebdriverUtility wLib = new WebdriverUtility();
		wLib.switchToAlert(driver);
		Thread.sleep(4000);
		AdminAddManufacturerPage aam = new AdminAddManufacturerPage(driver);
		aam.logoutAdmin();

		/* login as admin */
		String adminUSERNAME = fLib.getDataFromPropertyFile("adminusername");
		String adminPASSWORD = fLib.getDataFromPropertyFile("adminpassword");
		type = fLib.getDataFromPropertyFile("admintype");

		lp.login(adminUSERNAME, adminPASSWORD, type);
		/* click on product link check added product is displayed */
		AdminHomePage aHp = new AdminHomePage(driver);
		aHp.getProductLink().click();
		/* scroll to bottom */
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		AdminInfoPage aIp=new AdminInfoPage(driver);
		aIp.getProductsLink().click();
		String actProduct1=aIp.getProductsCheck().getText();
		boolean result1 = actProduct1.contains(productName);
		Assert.assertEquals(result1, true);
	}

}
