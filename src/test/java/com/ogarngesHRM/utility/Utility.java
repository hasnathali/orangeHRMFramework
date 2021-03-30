package com.ogarngesHRM.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	/*
	 * Sleep Explicit wait type click drop down assertion get text capture text
	 */

	public static void wait(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			System.out.println("Thread.Sleep Throwgh Exception.");
			e.printStackTrace();
		}
	}// end wait methods

	// Click
	public static void waitForClick(WebDriver driver, By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element))).click();
	}

	// Click
	public static void waitForClick(WebDriver driver, By element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element))).click();
	}

	// Wait for Visible of 
	public static void waitForVisible(WebDriver driver, By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	// Wait for Visible of 
	public static void waitForVisible(WebDriver driver, By element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	// Wait for Visible & Click 
		public static void waitForVisibleandClick(WebDriver driver, By element, int time) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
		}

	// wait for Title
	public static boolean waitForTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.titleContains(title));
	}
	//Wait for Title
	public static boolean waitForTitle(WebDriver driver, String title, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleContains(title));
	}

	// Wait for URL
	public static boolean waitForCurrentURL(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.urlContains(url));
	}
	//Wait for URL
	public static boolean waitForCurrentURL(WebDriver driver, String url, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.urlContains(url));
	}

	public static WebElement findElement(WebDriver driver, By locator) {
		return driver.findElement(locator);
	}

	public static void click(WebDriver driver, By locator) {
		// driver.findElement(locator).click();
		// OR
		findElement(driver, locator).click();
	}

	public static void type(WebDriver driver, By locator, String data) {
		// driver.findElement(locator).sendKeys(data);
		findElement(driver, locator).sendKeys(data);
	}

	//Dropdown visible by text
	public static void selectTextFromDropBox(WebDriver driver, By locator, String text) {
		new Select(driver.findElement(locator)).selectByVisibleText(text);

	}
	//Dropdown visible by value
	public static void selectByValueFromDropBox(WebDriver driver, By locator, String text) {
		new Select(driver.findElement(locator)).selectByValue(text);

	}

	public static String getText(WebDriver driver, By locator) {
		return findElement(driver, locator).getText();
	}

	public static String captureScreenShort64(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		String img = "data:image/png;base64," + src;
		//System.out.println("Image data is " + img);
		return img;
	}

}// end class
