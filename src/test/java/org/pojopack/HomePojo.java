package org.pojopack;

import org.global.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePojo extends HelperClass {

	public HomePojo() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[@id='twotabsearchtextbox']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//*[@id='nav-search-submit-button']")
	private WebElement searchButtonClick;
	
	@FindBy(xpath = "//span[text()='1,636']")
	private WebElement scrollDownWebEle;
	
	
	@FindBy(xpath = "(//span[text()=' Skip '])[1]")
	private WebElement skip;
	
	
	
	
	public WebElement getSkip() {
		return skip;
	}


	@FindBy(xpath="(//a[@target='_blank'])[1]")
	private WebElement nokiaProduct;
	

	
	public WebElement getNokiaProduct() {
		return nokiaProduct;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchButtonClick() {
		return searchButtonClick;
	}

	public WebElement getScrollDownWebEle() {
		return scrollDownWebEle;
	}
	


	public WebElement getAddToCartButton() {
		return addToCartButton;
	}


//	@FindBy(xpath = "(//*[contains(text() , 'Analog Black Dial')])[1]")
//	private WebElement firstproductClick;

	
	@FindBy(xpath = "//input[@title='Add to Shopping Cart']")
	private WebElement addToCartButton ;

	
//	
//	public WebElement getFirstproductClick() {
//		return firstproductClick;
//	}

	public WebElement getAddToCaartButton() {
		return addToCartButton;
	}
	
	
	


	


	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(xpath="//span[text()='Sign in']")
	private WebElement login;
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement username;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement signinBtn;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement otp;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueBtn;
	

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getOtp() {
		return otp;
	}

	public WebElement getSigninBtn() {
		return signinBtn;
	}

	public WebElement getUsername() {
		return username;
	}
	
	

	public WebElement getEmail() {
		return email;
	}

	public WebElement getLogin() {
		return login;
	}

	
	
	
	
}
