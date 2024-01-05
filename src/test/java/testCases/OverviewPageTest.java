package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckOutPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.OverviewPage;
import utility.ReadData;
import utility.Screenshot;

public class OverviewPageTest extends TestBase{

	LoginPage login;      //here we need login page object everytime becauze lgin come before inventory
	InventoryPage invent; 
	CartPage cart;
	CheckOutPage check1;
	OverviewPage view;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent = new InventoryPage();
		cart = new CartPage();
		check1 = new CheckOutPage();
		view = new OverviewPage();
		login.loginToApplication();   //in before method we need to login firt then we can perform inventry actio so we are call loginpage method
		invent.add6Products();
		invent.clickCartIcon();
		cart.clickOncheckOutBtn();
		check1.inputInfo();
	}
	
	@Test (enabled = true)
	public void verifyOverviewPageUrlTest() throws EncryptedDocumentException, IOException {
		String expUrl = ReadData.readExelData(0, 13); //https://www.saucedemo.com/checkout-step-two.html (0,13)
		String actUrl = view.verifyOverviewPageUrl();
		Assert.assertEquals(expUrl, actUrl);
	}
	
	@Test (enabled = true)
	public void verifyOverviewPageLableTest() throws EncryptedDocumentException, IOException {
		String expTxt = ReadData.readExelData(0, 14); //Checkout: Overview (0,14)
		String actTxt = view.verifyOverviewPageLable();
		Assert.assertEquals(expTxt, actTxt);
	}
	
	@Test (enabled = true)
	public void verifyCardNumberTest() throws EncryptedDocumentException, IOException {
		String expTxt = ReadData.readExelData(0, 15); //SauceCard #31337 (0,15)
		String actTxt = view.verifyCardNumber();
		Assert.assertEquals(expTxt, actTxt);
	}
	
	
	@Test (enabled = true)
	public void verifyDiliveryAddressTest() throws EncryptedDocumentException, IOException {
		String expTxt = ReadData.readExelData(0, 16); //Free Pony Express Delivery! (0,16)
		String actTxt = view.verifyDiliveryAddress();
		Assert.assertEquals(expTxt, actTxt);
	}
	
	@Test (enabled = true)
	public void verifyTotalPriceTest() throws EncryptedDocumentException, IOException {
		String expTxt ="Total: $140.34"; //ReadData.readExelData(0, 17); //Total: $140.34 (0,17)
		String actTxt = view.verifyTotalPrice();
		Assert.assertEquals(expTxt, actTxt);
	}
	
	@Test (enabled = true)
	public void verifyFinishBtnTest() throws EncryptedDocumentException, IOException {
		String expUrl = ReadData.readExelData(0, 18); //https://www.saucedemo.com/checkout-complete.html (0,18)
		String actUrl = view.verifyFinishBtn();
		Assert.assertEquals(expUrl, actUrl);
	}
	
	@Test (enabled = true)
	public void verifyCancelBtnTest() throws EncryptedDocumentException, IOException {
		String expUrl = ReadData.readExelData(0, 19); //https://www.saucedemo.com/inventory.html (0,19)
		String actUrl = view.verifyCancelBtn();
		Assert.assertEquals(expUrl, actUrl);
	}
	
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus()) {
			Screenshot.screenshot(it.getName());
		}
		driver.close();
	}
}

