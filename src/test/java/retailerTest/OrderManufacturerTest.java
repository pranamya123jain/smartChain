package retailerTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.SCM.Basetest.BaseclassTest;
import com.SCM.ObjectrepositoryUtility.AdminAddManufacturerPage;
import com.SCM.ObjectrepositoryUtility.LoginPage;
import com.SCM.ObjectrepositoryUtility.ManufacturerHomePage;
import com.SCM.ObjectrepositoryUtility.RetailerNewOrderPage;
import com.SCM.generic.fileUtility.FileUtility;

public class OrderManufacturerTest extends BaseclassTest{
@Test(groups = {"regression test"})
public void manufacturerAproveProduct() throws Throwable
{
	FileUtility fLib = new FileUtility();
	String retailerUSERNAME = fLib.getDataFromPropertyFile("retailerusername");
	String retailerpassword = fLib.getDataFromPropertyFile("retailerpassword");
	String type = fLib.getDataFromPropertyFile("retailertype");
	LoginPage lp = new LoginPage(driver);
	lp.login(retailerUSERNAME, retailerpassword, type);
	
	String qTy = eLib.getDtaFromExcel("Retailer product", 1, 1);
	RetailerNewOrderPage rNop=new RetailerNewOrderPage(driver);
	rNop.newOrder(qTy);
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	rNop.getPostorderBtn();
	
	AdminAddManufacturerPage aam=new AdminAddManufacturerPage(driver);
	aam.logoutAdmin();	//logout as retailer
	String manufacturerUSERNAME = fLib.getDataFromPropertyFile("manufactureruser");
	String manufacturepassword = fLib.getDataFromPropertyFile("manufacturerpassword");
	String mtype = fLib.getDataFromPropertyFile("manufacturertype");
	LoginPage mlp = new LoginPage(driver);
	mlp.login(manufacturerUSERNAME, manufacturepassword, mtype);
	ManufacturerHomePage mP=new ManufacturerHomePage(driver);
	mP.getOrdersLink().click();
	
	mP.getConfirmLink().click();
	
//	String date = jLib.getSystemDateddMMyyyy();
}
}
