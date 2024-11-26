package adminTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SCM.Basetest.BaseclassTest;
import com.SCM.ObjectrepositoryUtility.AdminAddManufacturerPage;
import com.SCM.ObjectrepositoryUtility.AdminInfoPage;
import com.SCM.ObjectrepositoryUtility.LoginPage;
import com.SCM.generic.fileUtility.FileUtility;

public class addManufacturerTest extends BaseclassTest {

	@Test(groups = {"regression test"})
	public void addManufacturertest() throws Throwable {

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
		
		System.out.println("result:"+result+"\t"+"actMunucature:"+actMunucature);
		
		// aam.logoutAdmin();
	}

	@Test(groups = {"smoke test"})
	public void loginManufacturer() throws Throwable {
		FileUtility fLib = new FileUtility();
		String manufacturerUSERNAME = fLib.getDataFromPropertyFile("manufactureruser");
		String manufacturepassword = fLib.getDataFromPropertyFile("manufacturerpassword");
		String type = fLib.getDataFromPropertyFile("manufacturertype");
		LoginPage lp = new LoginPage(driver);
		lp.login(manufacturerUSERNAME, manufacturepassword, type);
	}
	
}
