package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.InventoryPage;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class InventoryPageTest extends TestBase{

	LoginPage login;      //here we need login page object everytime becauze lgin come before inventory
	InventoryPage invent;   
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent = new InventoryPage();
		login.loginToApplication();   //in before method we need to login firt then we can perform inventry actio so we are call loginpage method
	}
	
	@Test (enabled = true,  groups = {"Retesting"})
	public void verifyProductLabelTest() throws EncryptedDocumentException, IOException {
		String expTitle = ReadData.readExelData(0, 3);//"Products" (0 , 3);
		String actTitle =invent.verifyProductLabel();
		AssertJUnit.assertEquals(expTitle, actTitle);
		Reporter.log("Product title verification done");
	}
	
	@Test (enabled = true,  groups = {"Sanity", "Regression"})
	public void add6ProductsTest() throws IOException {
		String expCount = ReadData.readExelData(0, 4); //"6" (0,4);
		String actCount = invent.add6Products();
		AssertJUnit.assertEquals(expCount, actCount);
		Reporter.log("6 products added to cart successfully");
	}
	
	@Test (enabled = true)
	public void remove2ProductsTest() throws IOException {
		String expCount = ReadData.readExelData(0, 5);//"4" (0,5);
		String actCount = invent.remove2Products();
		AssertJUnit.assertEquals(expCount, actCount);
		Reporter.log("NumNumber of Products after removing :"+ actCount);
	}
	
	//social media logo verification test
	@Test (enabled = true,  groups = {"Sanity"})
	public void verifyTwitterLogoTest() {
		boolean result = invent.verifyTwitterLogo();
		AssertJUnit.assertEquals(result, true);
		Reporter.log("Visibility of twitter logo :" + result);
	}
	@Test (enabled = true)
	public void verifyFacebookLogoTest() {
		boolean result = invent.verifyFacebookLogo();
		AssertJUnit.assertEquals(result, true);
		Reporter.log("Visibility of facebook logo :" + result);
	}
	@Test (enabled = true)
	public void verifyLinkdinLogoTest() {
		boolean result = invent.verifyLinkdinLogo();
		AssertJUnit.assertEquals(result, true);
		Reporter.log("Visibility of linkdin logo :" + result);
	}
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus()) {
			Screenshot.screenshot(it.getName());
		}
		driver.close();
	}
}
