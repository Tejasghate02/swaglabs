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
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class CartPageTest extends TestBase{

	LoginPage login;      //here we need login page object everytime becauze lgin come before inventory
	InventoryPage invent; 
	CartPage cart;
	
	@BeforeMethod (alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent = new InventoryPage();
		cart = new CartPage();
		login.loginToApplication();   //in before method we need to login firt then we can perform inventry actio so we are call loginpage method
		invent.add6Products();
		invent.clickCartIcon();
	}
	
	@Test(enabled = true,  groups = {"Sanity"})
	public void verifyCartPageUrlTest() throws EncryptedDocumentException, IOException {
		String expUrl = "https://www.saucedemo.com/cart.html"; //ReadData.readExelData(0, 6); //https://www.saucedemo.com/cart.html (0 , 6)
		String actUrl = cart.verifyCartPageUrl();
		AssertJUnit.assertEquals(expUrl, actUrl);
		Reporter.log("current page url of cart page: "+ actUrl);
	}
	
	@Test (enabled = true,  groups = {"Retesting"})
	public void VerifyCartPageLableTest() throws EncryptedDocumentException, IOException {  
		String expUrl = ReadData.readExelData(0, 7); //Your Cart (0,7)
		String actUrl = cart.VerifyCartPageLable();
		AssertJUnit.assertEquals(expUrl, actUrl);
		Reporter.log("cart page lable: "+ actUrl);
	}
	
	@Test (enabled = true, groups = {"Retesting"})
	public void clickOncheckOutBtnTest() throws EncryptedDocumentException, IOException {
		cart.clickOncheckOutBtn();
		String expUrl = ReadData.readExelData(0, 8);  //https://www.saucedemo.com/checkout-step-one.html (0,8)
		String actUrl = driver.getCurrentUrl();
		AssertJUnit.assertEquals(expUrl, actUrl);
		Reporter.log("after checkout button clicked url: "+ actUrl);
	}
	
	@Test (enabled = true, groups = {"Regression"})
	public void clickContinueShoppingBtnTest() throws EncryptedDocumentException, IOException {
		cart.clickContinueShoppingBtn();
		String expUrl = ReadData.readExelData(0, 9); //https://www.saucedemo.com/inventory.html (0,9)
		String actUrl = driver.getCurrentUrl();
		AssertJUnit.assertEquals(expUrl, actUrl);
		Reporter.log("After continue shopping btn click url is: " + actUrl); 
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
