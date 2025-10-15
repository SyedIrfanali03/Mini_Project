package org.pojopack;

import org.global.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends HelperClass {

	public CartPage() {
	PageFactory.initElements(driver, this);	
	
	}
	
	@FindBy(xpath = "(//*[@class='a-button-inner']//child::a)[3]")
	private WebElement goToCartClick;
	
	@FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
	private WebElement proceedToBuyClick;


	@FindBy(xpath = "(//*[text()=' Skip '])[2]")
	private WebElement skipButtonClick;


	public WebElement getGoToCartClick() {
		return goToCartClick;
	}


	public WebElement getProceedToBuyClick() {
		return proceedToBuyClick;
	}


	public WebElement getSkipButtonClick() {
		return skipButtonClick;
	}
	
	
	
	
	
}
