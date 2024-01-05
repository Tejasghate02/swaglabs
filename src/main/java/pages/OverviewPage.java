package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class OverviewPage extends TestBase{

	@FindBy(xpath="//div[text()='SauceCard #31337']") private WebElement cardNumber;
	@FindBy(xpath="//div[text()='Free Pony Express Delivery!']") private WebElement diliveryAddress;
	@FindBy(xpath="//div[@class='summary_info_label summary_total_label']") private WebElement totalPrice;
	@FindBy(xpath="//span[text()='Checkout: Overview']") private WebElement overviewPageLable;
	@FindBy(xpath="//button[@id='finish']") private WebElement finishBtn;
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancelBtn;
	
	//constructor
	public OverviewPage (){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyOverviewPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String verifyOverviewPageLable() {
		return overviewPageLable.getText();
	}
	
	public String verifyCardNumber() {
		return cardNumber.getText();
	}
	
	public String verifyDiliveryAddress() {
		return diliveryAddress.getText();
	}
	
	public String verifyTotalPrice() {
		return totalPrice.getText();
	}
	
	public String verifyCancelBtn() {
		cancelBtn.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyFinishBtn() {
		finishBtn.click();
		return driver.getCurrentUrl();
	}
	
}
