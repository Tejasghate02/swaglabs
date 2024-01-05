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
import utility.ReadData;
import utility.Screenshot;

public class CheckOutPageTest extends TestBase {

	LoginPage login;      //here we need login page object everytime becauze lgin come before inventory
	InventoryPage invent; 
	CartPage cart;
	CheckOutPage check1;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent = new InventoryPage();
		cart = new CartPage();
		check1 = new CheckOutPage();
		login.loginToApplication();   //in before method we need to login firt then we can perform inventry actio so we are call loginpage method
		invent.add6Products();
		invent.clickCartIcon();
		cart.clickOncheckOutBtn();
		
	}
	@Test (enabled = true)
	public void verifyUrlTest() throws EncryptedDocumentException, IOException {
		String expUrl = ReadData.readExelData(0, 10); //https://www.saucedemo.com/checkout-step-one.html (0, 10)
		String actUrl = check1.verifyUrl();
		Assert.assertEquals(expUrl, actUrl);
	}
	
	@Test (enabled = true)
	public void verifyCheckOutLableTest() throws EncryptedDocumentException, IOException {
		String expTxt = ReadData.readExelData(0, 11); //Checkout: Your Information (0,11)
		String actTxt = check1.verifyCheckOutLable();
		Assert.assertEquals(expTxt, actTxt);
	}
	
	@Test (enabled = true)
	public void inputInfoTest() throws EncryptedDocumentException, IOException {
		String expUrl = ReadData.readExelData(0, 12); //https://www.saucedemo.com/checkout-step-two.html (0,12)
		String actUrl = check1.inputInfo();
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
