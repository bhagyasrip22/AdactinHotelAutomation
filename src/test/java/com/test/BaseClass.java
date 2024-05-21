package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import junit.framework.Assert;

public class BaseClass {

	static WebDriver driver;

	public void getdriver() {
		driver = new ChromeDriver();
	}

	public void getURl() {
		driver.get("https://adactinhotelapp.com/");
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public String getTextForElementByXpath(String xpathValue) {
		WebElement weByXPath = driver.findElement(By.xpath(xpathValue));
		return weByXPath.getText();
	}

	public WebElement findElementByXpath(String xpathValue) {
		WebElement weById = driver.findElement(By.xpath(xpathValue));
		return weById;
	}

	public List<WebElement> findElementsByXpath(String xpathValue) {
		return driver.findElements(By.xpath(xpathValue));
	}

	public WebElement findElementById(String id) {
		WebElement weById = driver.findElement(By.id(id));
		return weById;
	}

	public WebElement findElementByName(String name) {
		WebElement weByName = driver.findElement(By.name(name));
		return weByName;
	}

	public void typeKeys(WebElement we, String filePath, String sheetName, int rowNo, int cellNo) {

		String keys = excelRead(filePath, sheetName, rowNo, cellNo);
		we.sendKeys(keys);
	}

	public Select createSelect(WebElement we) {
		return new Select(we);
	}

	public void setSelectByVisibleText(Select select, String value) {
		select.selectByVisibleText(value);
	}

	public void assert1(String text) {
		Assert.assertEquals("verification", "Adactin Launches The Adactin Hotel App!", text);
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public String getAttributeValue(WebElement we, String key) {
		return we.getAttribute(key);
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public String excelRead(String filepath, String sheetname, int rowIndex, int cellIndex) {
		String value = null;
		System.out.println("Reading RowNo:" + rowIndex);
		System.out.println("Reading CellNo:" + cellIndex);
		try {
			File file = new File(filepath);
			FileInputStream input = new FileInputStream(file);

			Workbook book = new XSSFWorkbook(input);
			Sheet sheet = book.getSheet(sheetname);
			Row row = sheet.getRow(rowIndex);
			Cell cell = row.getCell(cellIndex);
			int cellType = cell.getCellType();
//			FileOutputStream output = new FileOutputStream(file);
			
			if (cellType == 1) {
				value = cell.getStringCellValue();
				System.out.println(value);

			} else {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date d = cell.getDateCellValue();
					SimpleDateFormat simple = new SimpleDateFormat("DD/MM/YYYY");
					value = simple.format(d);
					System.out.println(value);

				} else {
					double d = cell.getNumericCellValue();
					long l = (long) d;
					value = String.valueOf(l);
					System.out.println(value);

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found: "+filepath);
			e.printStackTrace();
		}
		System.out.println("Value of "+rowIndex+" "+cellIndex+" :"+value);
		return value;
	}

}
