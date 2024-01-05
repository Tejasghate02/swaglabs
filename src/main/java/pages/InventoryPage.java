package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropdownList;

public class InventoryPage extends TestBase{

	//creating the object repository
	@FindBy(xpath="//span[text()='Products']") private WebElement InventoryPageTitle;
	
	//adding product xpath
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTshirtProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceJacketProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement oneSieTshirtProduct;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement redTshirtProduct;
	
	//remove product xpath
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement backPackRemoveProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement bikeLightRemoveProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement boltTshirtRemoveProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement fleeceJacketRemoveProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement oneSieTshirtRemoveProduct;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement redTshirtRemoveProduct;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement TwitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement linkdinLogo;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement productDropDown;
	
	//constructor
	public InventoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	//inventory page label verification method
	public String verifyProductLabel() {
		return InventoryPageTitle.getText();
	}
	
	//logo verification methods
	public Boolean verifyTwitterLogo() {
		return TwitterLogo.isDisplayed();
	}
	public Boolean verifyFacebookLogo() {
		return facebookLogo.isDisplayed();
	}
 	public Boolean verifyLinkdinLogo() {
 		return linkdinLogo.isDisplayed();
 	} 
 	
 	//adding products to cart method
 	public String add6Products() throws IOException {
 		HandleDropdownList.handleSelectClass(productDropDown, "Price (low to high)");
 		backPackProduct.click();
 		bikeLightProduct.click();
 		boltTshirtProduct.click();
 		fleeceJacketProduct.click();
 		oneSieTshirtProduct.click();
 		redTshirtProduct.click();
 		return cartCount.getText();
 	}
 	
 	//method to remove product
 	public String remove2Products() throws IOException {
 		add6Products();
 		backPackRemoveProduct.click();
 		bikeLightRemoveProduct.click();
 		return cartCount.getText();
 	}
 	
 	public void clickCartIcon() {
 		cartIcon.click();
 	}
}
