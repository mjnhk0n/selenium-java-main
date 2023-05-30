package Selenium_Exercise;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_Topic20_JavaScript_Executor {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 15);
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_automationfc() {
		executeForBrowser("window.location='https://automationfc.github.io/html5/index.html'");
		sleepInSecond(5);
		String submitButton = "//input[@name='submit-btn']";
		String fullNameTextBox = "//input[@type='name']";
		String passwordTextBox = "//input[@type='password']";
		String emailTextBox = "//input[@type='email']";
		
		// Click submit and verify displayed message
		clickToElementByJS(submitButton);
		Assert.assertEquals(getElementValidationMessage("//input[@type='name']"), "Please fill out this field.");

		// Fill data in Name textbox, click Submit and verify message of password
		// textbox
		sendkeyToElementByJS(fullNameTextBox, "MinhTN");
		clickToElementByJS(submitButton);
		Assert.assertEquals(getElementValidationMessage(passwordTextBox), "Please fill out this field.");

		// Fill data in Password textbox, click submit and verify message of Email
		// textbox
		sendkeyToElementByJS(passwordTextBox, "123456");
		clickToElementByJS(submitButton);
		Assert.assertEquals(getElementValidationMessage("//input[@type='email']"), "Please fill out this field.");

		// Fill in INVALID data (no @) in Email textbox, click submit and verify message
		// of Email textbox
		sendkeyToElementByJS(emailTextBox, "2134sA2.abc");
		clickToElementByJS(submitButton);
		sleepInSecond(3);
		Assert.assertTrue(getElementValidationMessage(emailTextBox)
				.contains("Please enter an email address."));
		
		// Fill in INVALID data (with @ and no .) in Email textbox, click submit and verify message
		// of Email textbox
		sendkeyToElementByJS(emailTextBox, "2134@abc");
		clickToElementByJS(submitButton);
		sleepInSecond(3);
		Assert.assertTrue(getElementValidationMessage(emailTextBox)
				.contains("Please match the requested format."));
		
		// Fill in valid email data, click submit and verify message of Address
		sendkeyToElementByJS(emailTextBox, "2134@abc.123");
		clickToElementByJS(submitButton);
		Assert.assertTrue(getElementValidationMessage("//li//select")
				.contains("Please select an item in the list."));
	}

	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean expectedTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
		sleepInSecond(3);
	}

	public void hightlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(String locator) {
		jsExecutor.executeScript("arguments[0].click();", getElement(locator));
		sleepInSecond(3);
	}

	public void scrollToElementOnTop(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}

	public void scrollToElementOnDown(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
	}

	public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
		jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');",
				getElement(locator));
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
	}

	public void sendkeyToElementByJS(String locator, String value) {
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
	}

	public String getAttributeInDOM(String locator, String attributeName) {
		return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');",
				getElement(locator));
	}

	public String getElementValidationMessage(String locator) {
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
	}


	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 1000ms = 1s
	}

//	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}