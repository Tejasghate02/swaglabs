package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage extends TestBase {

	//object repository
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstNameTxtBox;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastNameTxtBox;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement postalNameTxtBox;
	@FindBy(xpath="//span[text()='Checkout: Your Information']") private WebElement checkOutPageLable;
	@FindBy(xpath="//input[@id='continue']") private WebElement continueBtn;
	
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyUrl() {
		return driver.getCurrentUrl();
	}
	
	public String verifyCheckOutLable() {
		return checkOutPageLable.getText();
	}
	
	public String inputInfo() {
		firstNameTxtBox.sendKeys("Tejas");
		lastNameTxtBox.sendKeys("Ghate");
		postalNameTxtBox.sendKeys("442301");
		continueBtn.click();
		return driver.getCurrentUrl();
	}
}
