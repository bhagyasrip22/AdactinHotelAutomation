package com.test;

import java.time.Duration;
import java.util.Stack;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class TestClass1 extends BaseClass {
	static WebDriver driver;

	static TestClass1 tc1 = new TestClass1();
	static String filePath = "C:\\Users\\Nagesh\\eclipse-workspace\\AdactinHotelAutomation\\src\\Excel\\AdactinHotelExcelRead.xlsx";
	static String sheetNo = "sheet1";

	@BeforeClass
	public static void login() {
		// driver = new ChromeDriver();
		tc1.getdriver();

		// driver.get("https://adactinhotelapp.com/");
		tc1.getURl();

		// driver.manage().window().maximize();
		tc1.maximize();

		// WebElement txtfromlogin =
		// driver.findElement(By.xpath("//p[@style='text-align:center;']"));
		// String text = txtfromlogin.getText();
		// System.out.println(text);
		String text = tc1.getTextForElementByXpath("//p[@style='text-align:center;']");
		System.out.println(text);

		// Assert.assertEquals("verification", "Adactin Launches The Adactin Hotel
		// App!", text);
		tc1.assert1(text);

		// WebElement logo = driver.findElement(By.xpath("//img[@class='logo']"));
//		String logoText = tc1.getTextForElementByXpath("//img[@class='logo']");
//		System.out.println(logoText);

		// WebElement txtusername = driver.findElement(By.id("username"));
		// txtusername.sendKeys("bhagyasrip");
		WebElement weUserName = tc1.findElementById("username");
		// tc1.typeKeys(weUserName, "bhagyasrip");
		tc1.typeKeys(weUserName, filePath, sheetNo, 1, 1);

		// WebElement txtpassword = driver.findElement(By.id("password"));
		// txtpassword.sendKeys("Sandy123$");
		WebElement wePassword = tc1.findElementById("password");
		tc1.typeKeys(wePassword, filePath, sheetNo, 1, 2);
		//
		// WebElement login = driver.findElement(By.name("login"));
		// login.click();
		WebElement weLoginName = tc1.findElementByName("login");
		weLoginName.click();
	}

	@Before
	public void select() {
		// login_01();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// WebElement location = driver.findElement(By.id("location"));
		// Select select = new Select(location);
		WebElement weLocation = tc1.findElementById("location");
		Select locationSelect = tc1.createSelect(weLocation);

		// select.selectByVisibleText("New York");
		tc1.setSelectByVisibleText(locationSelect, "New York");

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		tc1.implicitWait();

		// WebElement Hotel = driver.findElement(By.id("hotels"));
		// Select select1 = new Select(Hotel);
		WebElement weHotel = tc1.findElementById("hotels");
		Select hotelSelect = tc1.createSelect(weHotel);

		// select1.selectByVisibleText("Hotel Sunshine");
		tc1.setSelectByVisibleText(hotelSelect, "Hotel Sunshine");

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		tc1.implicitWait();

		// WebElement ROOM = driver.findElement(By.name("room_type"));
		// Select select2 = new Select(ROOM);
		WebElement weRoom = tc1.findElementByName("room_type");
		Select roomSelect = tc1.createSelect(weRoom);

		// select2.selectByVisibleText("Double");
		tc1.setSelectByVisibleText(roomSelect, "Double");

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		tc1.implicitWait();

		// WebElement Rooms_No = driver.findElement(By.id("room_nos"));
		// Select select3 = new Select(Rooms_No);
		WebElement weRoomNo = tc1.findElementById("room_nos");
		Select roomNoSelect = tc1.createSelect(weRoomNo);

		// select3.selectByVisibleText("2 - Two");
		tc1.setSelectByVisibleText(roomNoSelect, "2 - Two");

		// WebElement Entrydate =
		// driver.findElement(By.xpath("//input[@name='datepick_in']"));
		// Entrydate.clear();
		// Entrydate.sendKeys("18/12/2024");
		WebElement weEntryDate = tc1.findElementByXpath("//input[@name='datepick_in']");
		weEntryDate.clear();
		tc1.typeKeys(weEntryDate, filePath, sheetNo, 1, 3);

		// WebElement Exitdate =
		// driver.findElement(By.xpath("//input[@name='datepick_out']"));
		// Exitdate.clear();
		// Exitdate.sendKeys("20/12/2024");
		WebElement weExitDate = tc1.findElementByXpath("//input[@name='datepick_out']");
		weExitDate.clear();
		tc1.typeKeys(weExitDate, filePath, sheetNo, 1, 4);

		// WebElement Adultrooms = driver.findElement(By.id("adult_room"));
		// Select select4 = new Select(Rooms_No);
		// select4.selectByVisibleText("1 - One");
		WebElement weAdultrooms = tc1.findElementById("adult_room");
		Select adultroomsSelect = tc1.createSelect(weAdultrooms);
		tc1.setSelectByVisibleText(adultroomsSelect, "1 - One");

		// WebElement Childrooms = driver.findElement(By.id("child_room"));
		// Select select5 = new Select(Childrooms);
		// select5.selectByVisibleText("1 - One");
		WebElement weChildrooms = tc1.findElementById("child_room");
		Select childRoomsSelect = tc1.createSelect(weChildrooms);
		tc1.setSelectByVisibleText(childRoomsSelect, "1 - One");

		// WebElement submit = driver.findElement(By.id("Submit"));
		WebElement weSubmit = tc1.findElementById("Submit");
		weSubmit.click();
	}

	@Test
	public void selectahotel() {
		// WebElement button = driver.findElement(By.id("radiobutton_0"));
		// button.click();
		WebElement weButton = tc1.findElementById("radiobutton_0");
		weButton.click();

		// WebElement submit1 = driver.findElement(By.id("continue"));
		// submit1.click();
		WebElement weContinue = tc1.findElementById("continue");
		weContinue.click();

	}

	@After
	public void BookAHotel() {
		// WebElement firstname = driver.findElement(By.id("first_name"));
		// firstname.sendKeys("chandini");
		WebElement weFirstName = tc1.findElementById("first_name");
		tc1.typeKeys(weFirstName, filePath, sheetNo, 1,5);

		// WebElement lastname = driver.findElement(By.id("last_name"));
		// lastname.sendKeys("xyyyz");
		WebElement weLastName = tc1.findElementById("last_name");
		tc1.typeKeys(weLastName,filePath, sheetNo, 1,6);

		// WebElement address = driver.findElement(By.id("address"));
		// address.sendKeys("jkjshdjks\n8976 new york streeet\nxyzd");
		WebElement weAddress = tc1.findElementById("address");
		tc1.typeKeys(weAddress, filePath, sheetNo, 1, 7);
		//
		// WebElement creditcard = driver.findElement(By.id("cc_num"));
		// creditcard.sendKeys("4012888888881881");
		WebElement weCreditCard = tc1.findElementById("cc_num");
		tc1.typeKeys(weCreditCard, filePath, sheetNo, 1, 8);

		// WebElement cctype = driver.findElement(By.id("cc_type"));
		// Select select7 = new Select(cctype);
		// select7.selectByVisibleText("American Express");
		WebElement weCcType = tc1.findElementById("cc_type");
		Select ccTypeSelect = tc1.createSelect(weCcType);
		tc1.setSelectByVisibleText(ccTypeSelect, "American Express");

		// WebElement creditexpmonth = driver.findElement(By.id("cc_exp_month"));
		// Select select8 = new Select(creditexpmonth);
		// select8.selectByVisibleText("August");
		WebElement weCreditExpMonth = tc1.findElementById("cc_exp_month");
		Select creditExpMonthSelect = tc1.createSelect(weCreditExpMonth);
		tc1.setSelectByVisibleText(creditExpMonthSelect, "August");

		// WebElement creditesxpyear = driver.findElement(By.id("cc_exp_year"));
		// Select select9 = new Select(creditesxpyear);
		// select9.selectByVisibleText("2027");
		WebElement weCreditExpYear = tc1.findElementById("cc_exp_year");
		Select creditExpYearSelect = tc1.createSelect(weCreditExpYear);
		tc1.setSelectByVisibleText(creditExpYearSelect, "2027");
		//
		// WebElement cvv = driver.findElement(By.id("cc_cvv"));
		// cvv.sendKeys(" 371111111111114");
		WebElement weCvv = tc1.findElementById("cc_cvv");
		tc1.typeKeys(weCvv, filePath, sheetNo, 1, 9);

		// WebElement submit3 = driver.findElement(By.id("book_now"));
		// submit3.click();$
		WebElement weBookNow = tc1.findElementById("book_now");
		weBookNow.click();
		// CRSJQKYZUC
	}

	@AfterClass
	public static void cancellation() {
		// WebElement order_no =
		// driver.findElement(By.xpath("//input[@name='order_no']"));
		// String value = order_no.getAttribute("value");
		// System.out.println(value);
		WebElement weOrderNo = tc1.findElementByXpath("//input[@name='order_no']");
		String orderNo = tc1.getAttributeValue(weOrderNo, "value");

		// WebElement iternary = driver.findElement(By.id("my_itinerary"));
		// iternary.click();
		WebElement weItinary = tc1.findElementById("my_itinerary");
		weItinary.click();

		// List<WebElement> cancelbtns =
		// driver.findElements(By.xpath("//input[@type='button']"));
		List<WebElement> weCancelBtns = tc1.findElementsByXpath("//input[@type='button']");
		for (int i = 0; i < weCancelBtns.size(); i++) {
			String cancelOrderButtonValue = weCancelBtns.get(i).getAttribute("value");
			System.out.println("Current Cancel Button Value: " + cancelOrderButtonValue + " actual order: " + orderNo);
			if (cancelOrderButtonValue.contains(orderNo)) {
				System.out.println("Value Matched, Clicking the button to cancel: " + cancelOrderButtonValue);
				weCancelBtns.get(i).click();
				tc1.acceptAlert();
				break;

			}
		}

	}
}
