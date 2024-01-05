package testCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.CartPage;
import pages.CheckOutPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.OverviewPage;
import utility.Screenshot;

public class VerifyLoginMultipleCredentials extends TestBase {

	LoginPage login;      //here we need login page object everytime becauze lgin come before inventory
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
	}
	
	//data provider method to read multiple credentials 
	@DataProvider(name = "credentials")
	public Object [][] getData() {
		return new Object[][] {
			{"standard_user", "secret_sauce"},
			{"locked_out_user", "secret_sauce"},
			{"problem_user", "secret_sauce"},
			{"performance_glitch_user", "secret_sauce"},
			{"error_user", "secret_sauce"},
			{"visual_user", "secret_sauce"}
		};
	}
	
	
	@Test (dataProvider = "credentials")
	public void loginWithMultipleCredentialsTest(String user, String pass) {
		SoftAssert soft = new SoftAssert();
		String expUrl = "https://www.saucedemo.com/inventory.html";
		String actUrl = login.loginWithMultipleCredentials(user, pass);
		soft.assertAll();
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
