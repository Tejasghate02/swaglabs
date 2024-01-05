package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{
	//object repository
	@FindBy(xpath="//input[@name='user-name']") private WebElement usernameTextbox;
	@FindBy(xpath="//input[@name='password']") private WebElement passwordTextbox;
	@FindBy(xpath="//input[@name='login-button']") private WebElement loginButton;
	
	//constructer
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String loginToApplication() throws IOException {
		usernameTextbox.sendKeys(ReadData.readPropertyFile("Username"));
		passwordTextbox.sendKeys(ReadData.readPropertyFile("Password"));
		loginButton.click();
		return driver.getCurrentUrl();
		
	}
	
	public String loginWithMultipleCredentials(String userName, String password) {
		usernameTextbox.sendKeys(userName);
		passwordTextbox.sendKeys(password);
		loginButton.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyTitleOfApplication(){
		return driver.getTitle();
	}
	
	public String verifyURLOfApplication(){
		return driver.getCurrentUrl();
	}

}
