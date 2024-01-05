package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase {

	//creating object repository for cartpage
	@FindBy(xpath="//span[text()='Your Cart']") private WebElement cartPageLable;
	@FindBy(xpath="//button[@id='checkout']") private WebElement checkOutBtn;
	@FindBy(xpath="//button[@id='continue-shopping']") private WebElement continueShoppingBtn;
	
	//constructor
	public CartPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyCartPageLable() {
		return cartPageLable.getText();
	}
	
	public String verifyCartPageUrl() {
		return driver.getCurrentUrl();	
	}
	
	public void clickOncheckOutBtn() {
		checkOutBtn.click();
	}
	
	public void clickContinueShoppingBtn() {
		continueShoppingBtn.click();
	}
}
