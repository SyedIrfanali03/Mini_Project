package org.execute;

import java.io.IOException;

import org.global.HelperClass;
import org.openqa.selenium.WebElement;
import org.pojopack.CartPage;
import org.pojopack.HomePojo;
import org.pojopack.LoginPojo;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestExecution extends HelperClass{

	@BeforeClass
	private void amazonPage() {
		browserLaunch();
		loadUrl("https://www.amazon.in/");
		maxBrowser();
		implicitWaiting();
		
	}
	@BeforeMethod
	private void beforeDateTime() {
		
		dateTime();

	}
	
	@Test(priority = 0)
	private void login() throws IOException, InterruptedException {
		
		implicitWaiting();
		
		
		HomePojo h = new HomePojo();

		WebElement signin = h.getEmail();
		moveToElement(signin);
		
		WebElement login = h.getLogin();
		javaScriptExecutor("arguments[0].click()", login);

		 
		 
		WebElement username = h.getUsername();
		//String value = excelData("C:\\Users\\Syed Irfan\\eclipse-workspace\\Amazon_Project\\ExcelDatas\\Propertiess.xlsx", 0, 0);
		username.sendKeys("8056220250");
		
		
		
		
		
		WebElement signinBtn = h.getSigninBtn();
		signinBtn.click();
		
	
		
		WebElement otp = h.getOtp();
		otp.click();
		
		sleepMethod();
		
		WebElement continueBtn = h.getContinueBtn();
		continueBtn.click();
		
	}
	
	
	
	@Test(priority = 1)
	private void searchProduct() throws IOException, InterruptedException {
		
		
		HomePojo h = new HomePojo();
		
		implicitWaiting();
		
		String excelData = excelData("C:\\Users\\Syed Irfan\\eclipse-workspace\\Amazon_Project\\ExcelDatas\\Datas.xlsx", 1, 0);
		textFill(h.getSearchBox(),excelData);
		buttonClick(h.getSearchButtonClick());
		
		
		scriptdownPage(h.getScrollDownWebEle());
		getSnap("Titan Watch");
		buttonClick(h.getScrollDownWebEle());
		
		
		
		
//		buttonClick(h.getFirstproductClick());
//		buttonClick(h.getNokiaProduct());
//		WebElement nokiaProduct = h.getNokiaProduct();
//		nokiaProduct.click();
//		buttonClick(h.getPreOrder());
//		scriptdownPage(h.getPreOrder());
		
		
	}
	
	@Test(priority = 2)
	private void navigateProductAddToCart() throws InterruptedException {
		
		
		implicitWaiting();
		//select the first Product 
		HomePojo h = new HomePojo();
		
		CartPage c= new CartPage();
		handlingWindows(1);
		
		buttonClick(h.getAddToCaartButton());
		
		actionMouseClick(h.getSkip());
		buttonClick(h.getSkip());
		
		actionMouseClick(c.getGoToCartClick());
		buttonClick(c.getProceedToBuyClick());
		
		
		
		

	}
	
	@BeforeMethod
	private void afterDateTime() {
		
		dateTime();

	}
	
	
	private void suriya() {
		
		System.out.println("sample code for Suriya");

	}
	
	
	
	
	
	
}
