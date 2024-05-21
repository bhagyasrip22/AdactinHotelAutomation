package com.base;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.TestClass1;

public class Login extends TestClass1 {
	static WebDriver driver;

	@Override
	@Test
	public void selectahotel() {
		WebElement button = driver.findElement(By.id("radiobutton_0"));
		button.click();
		WebElement submit1 = driver.findElement(By.id("continue"));
		submit1.click();

	}

}
