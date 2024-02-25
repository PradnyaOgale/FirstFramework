package com.First_Framework.Keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.First_Framework.errors.InvalidBrowserError;
import com.First_Framework.exception.InvalidSelectorException;

public class Keyword {

	private static RemoteWebDriver driver = null;

	/**
	 * This method return the driver instance. Make sure before calling this method
	 * one should call {@code openBrowser(String broserName}} method so that it can
	 * initialize driver instance.
	 * 
	 * @return
	 */
	public static RemoteWebDriver getDriver() {
		return driver;
	}

	/**
	 * This method will launch specified browser
	 * 
	 * @param browserName
	 */
	public void openBrowser(String browserName) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver(option);
			System.out.println("Opening Chrome browser");

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Opening Firefox browser");

		} else {
			// System.out.println("Invalid browser name");
			throw new InvalidBrowserError(browserName);
		}
	}

	public void openUrl(String url) {

		driver.get(url);
		System.out.println("Launching Url");
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitAllWindows() {
		driver.quit();
	}

	/*
	 * public void clickOn(WebElement element) { element.click(); }
	 */
	public WebElement getWebElement(String locatorType, String locatorValue) {

		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("class")) {
			return driver.findElement(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			return driver.findElement(By.partialLinkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			return driver.findElement(By.linkText(locatorValue));
		} else {
			throw new InvalidSelectorException(locatorType);
		}

	}

	public List<WebElement> getWebElements(String locatorType, String locatorValue) {

		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElements(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElements(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("class")) {
			return driver.findElements(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			return driver.findElements(By.partialLinkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			return driver.findElements(By.linkText(locatorValue));
		} else {
			throw new InvalidSelectorException(locatorType);
		}

	}

	public void clickOn(String locatorType, String locatorValue) {

		getWebElement(locatorType, locatorValue).click();
	}

	private void enterText(String locatorType, String locatorValue, CharSequence... text) {

		getWebElement(locatorType, locatorValue).sendKeys(text);
	}

	public void enterText(String locator, CharSequence... text) {

		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		enterText(locatorType, locatorValue, text);
	}

	public void hitKey(int keyCode) {
		Robot robo;
		try {
			robo = new Robot();
			robo.keyPress(keyCode);
			robo.keyRelease(keyCode);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> getTexts(String locatorType, String locatorValue) {

		List<String> text = new ArrayList<String>();

		List<WebElement> elements = new ArrayList<WebElement>();

		elements = getWebElements(locatorType, locatorValue);

		for (WebElement element : elements) {
			text.add(element.getText());
		}

		return text;
	}

	public List<String> getTexts(String locator) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		return getTexts(locatorType, locatorValue);
	}

	public void maximizeBrowser() {

		driver.manage().window().maximize();

	}

	public List<String> getTexts(List<WebElement> items) {

		List<String> texts = new ArrayList<String>();

		for (WebElement item : items) {
			texts.add(item.getText());
		}
		return texts;

	}

	public void scrollWindow() {
		driver.executeScript("window.scrollBy(0,3700)");
	}

	public void handlingWindows() {
		String parent = getDriver().getWindowHandle();
		Set<String> win1 = driver.getWindowHandles();
		win1.remove(parent);

		for (String handles : win1) {
			driver.switchTo().window(handles);
			String title1 = driver.getCurrentUrl();
			System.out.println(title1);
			/*
			 * if(title.contains("second")) {
			 * driver.findElement(By.xpath("//button[text()=\"Click Me\"]")).click(); String
			 * text = driver.findElement(By.xpath("//p[@id=\"demo\"]")).getText();
			 * System.out.println(text); }
			 */

		}
	}

	public void refreshPage() {
		((RemoteWebDriver) getDriver().manage()).navigate().refresh();
	}

	public void hoverOn(WebElement elementToHover) {
		Actions actions = new Actions(Keyword.getDriver());
		actions.moveToElement(elementToHover).build().perform();
		;
	}

//-------------------------------------------------------------------------------------------
	public void switchToWindowByTitle(String title) {
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			driver.switchTo().window(handle);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}

	public void switchToWindowByGetCurrentUrl(String currentUrl) {
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			driver.switchTo().window(handle);
			if (driver.getCurrentUrl().equals(currentUrl)) {
				break;
			}
		}
	}

	public void getText(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).getText();
	}

	public String getText(WebElement element) {
		return element.getText();
	}
}
