package org.global;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HelperClass {

	public static WebDriver driver;
	public static Actions a;
	public static Select s;
	public static Alert alt;
	public static JavascriptExecutor js;

	// to launch the Browser
	public static void browserLaunch() {
		driver = new ChromeDriver();
	}

	public static String titleFetch() {
		String title = driver.getTitle();
		return title;
	}

	public static void maxBrowser() {
		driver.manage().window().maximize();
	}

	public static void closeBrowser() {
		driver.close();
	}

	// url Load
	public static void loadUrl(String urlLoad) {
		driver.get(urlLoad);
	}
	// sendkeys Alternate
	public static void textFill(WebElement ele, String text) {
		ele.sendKeys(text);
	}

	// move cursor
	public static void actionMouseHover(WebElement targetELe) {
		a = new Actions(driver);
		a.moveToElement(targetELe).perform();
	}
	
	public static void actionMouseClick(WebElement targetELe) {
		a = new Actions(driver);
		a.click(targetELe).perform();
	}

	public static void actionDragDrop(WebElement src, WebElement des) {
		a = new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}

	// TakeScreenshot reusable Method
	public static void getSnap(String fileName) throws IOException {

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Syed Irfan\\eclipse-workspace\\Amazon_Project\\ScreenShotFolder" + fileName + ".png");
		FileUtils.copyFile(src, des);

	}

	// javaScript
	public static void javaScriptSenKeys(String values, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + values + "')", ele);

	}
	
	// javaScript
		public static void javaScriptClickButton(WebElement ele) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", ele);

		}
		
	
	public static  void scriptdownPage(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)",ele );
	}

	// waits
	public static void implicitWaiting() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

	}

	public static void sleepMethod() throws InterruptedException {
		Thread.sleep(10000);

	}

	public static void buttonClick(WebElement ele) {
		ele.click();
	}

	// select class Method
	public static void dropdownselectValues(WebElement ele, String valueText) {
		s = new Select(ele);
		s.selectByValue(valueText);
	}

	public static void alertAcceptHandle() {
		alt = driver.switchTo().alert();
		alt.accept();

	}
	
	//handling windows Method 
		public static void handlingWindows(int childWindowNos) {
			
			Set<String> allWindow = driver.getWindowHandles();
			List<String> list = new LinkedList<String>();
			list.addAll(allWindow);
			
			driver.switchTo().window(list.get(childWindowNos));	
		}
	
	
		public static String excelData(String fileLocation , int rows, int cells) throws IOException {

			// Location of file
			File f = new File(fileLocation);

			// Read file FileinputStream
			FileInputStream fis = new FileInputStream(f);

			// Format of file XSSFWorkbook //Upcasting
			Workbook w = new XSSFWorkbook(fis);

			// get the sheet
			Sheet sheet = w.getSheetAt(0);

			// To get String cell value
			Row row = sheet.getRow(rows);

			Cell c = row.getCell(cells);

			String value ="";

			int cellType = c.getCellType();

			if (cellType == 1) {
				value = c.getStringCellValue();
				// System.out.println(value);
			}

			// To get Date cell value

			else if (DateUtil.isCellDateFormatted(c)) {
				Date dd = c.getDateCellValue();
				SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-DD");
				value = s.format(dd);
				// System.out.println(value);
			}

			else {
				double d = c.getNumericCellValue();
				long l = (long) d;
				value = String.valueOf(l);
				// System.out.println(value);
			}

			return value;

		}
		public static void dateTime() {
			Date d = new Date();
		
			
			System.out.println(d);

		}

		public void moveToElement(WebElement element) {

			a = new Actions(driver);
			a.moveToElement(element);

		}

		public static void javaScriptExecutor(String command, WebElement element) {

			js = (JavascriptExecutor) driver;
			js.executeScript(command, element);

		}
		
		public static void expected(String msg, WebElement expected, String actual) {
			
			Assert.assertEquals(expected, actual, msg);

		}

		
		public static void getAttributeMethod(WebElement element, String value) {
			
			String attribute = element.getAttribute(value);
			System.out.println(attribute);

		}
}


