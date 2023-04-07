package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_WebElement() {
		// To interact with element, must find it through their locator
		// By.id/ class/ name/ xpath/ css/ tagname/ linktext/ partiallinktext
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		
		// Need to register the variable if using the element continuously
		WebElement emailTextbox = driver.findElement(By.id("Email"));
		emailTextbox.isDisplayed();
		emailTextbox.clear();
		emailTextbox.sendKeys("");
		
		// No need to register if use the element only once
		driver.findElement(By.id("Email"));
		
		WebElement element = driver.findElement(By.id("Email"));
		// Use for text box/ text area/ drop down (editable)
		// Clear the data before input
		element.clear();
		// Input data
		element.sendKeys("");
		
		String searchAttribute = element.getAttribute("placeholder");
		
		// GUI testing
		element.getCssValue("background-color");
		
		// Take a screenshot for failed cases
		element.getScreenshotAs(OutputType.FILE);
		element.getScreenshotAs(OutputType.BASE64);
		element.getScreenshotAs(OutputType.BYTES);
		
		// Get the HTML tag name of element
		driver.findElement(By.xpath("//input[@id='Email']"));
		// Tag name above = input
		// Use when do not have the tag name of element and need transmit it to other locator
		
		
		
		
	}

	@Test
	public void TC_02_() {
	}

	@Test
	public void TC_03_() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}