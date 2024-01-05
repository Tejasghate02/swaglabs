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
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class LoginPageTest  extends TestBase
{
	LoginPage login;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
	}
	@Test (enabled = true, priority=1, groups = {"Retesting"})
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle= ReadData.readExelData(0, 0); //"Swag Labs" (0,0);
		String actTitle=login.verifyTitleOfApplication();
		AssertJUnit.assertEquals(expTitle, actTitle);
	}
	@Test (enabled = true,priority = 2, groups = {"Sanity"})
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExelData(0, 1); //"https://www.saucedemo.com/" (0,1);
		String actURL=login.verifyURLOfApplication();
		AssertJUnit.assertEquals(expURL, actURL);
	}
	@Test (enabled = true, priority=3, groups = {"Sanity", "Regression"})
	public void loginToApplicationTest() throws IOException {
		String expUrl = ReadData.readExelData(0, 2); //"https://www.saucedemo.com/inventory.html" (0,2);
		String actUrl = login.loginToApplication();
		AssertJUnit.assertEquals(expUrl, actUrl);
		Reporter.log("After successful login :" + actUrl);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus()) {
			Screenshot.screenshot(it.getName());
		}
		driver.close();
	}

}


