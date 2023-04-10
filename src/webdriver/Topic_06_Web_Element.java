package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

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

	public void WebElement() {
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
		// Tag name = input
		
		// Use when do not have the tag name of element and need transmit it to other locator
		driver.findElement(By.id("Email")).getTagName();
		driver.findElement(By.name("Email")).getTagName();
		
		String emailTextboxTagName = driver.findElement(By.cssSelector("#Email")).getTagName();
		
		driver.findElement(By.xpath("//" + emailTextboxTagName + "[@id='Email']"));
		
		// Get text from Error/Success message/ label/ header/...
		element.getText();
		// Please enter your email
		
		// Verify the element is displayed or not ( all elements are in range)
		Assert.assertTrue(element.isDisplayed());
		Assert.assertFalse(element.isDisplayed());
		
		// Verify the element is able or disable to interact (fill in/ click/...)
		Assert.assertTrue(element.isEnabled());
		Assert.assertFalse(element.isEnabled());
		
		// Verify the element is selected or not (check box/ drop down/...)
		Assert.assertTrue(element.isSelected());
		Assert.assertFalse(element.isSelected());
		
		// All elements in <form> card of HTML - Equals to press <Enter button>
		element.submit();
		
		/* 	If APIs have the prefix 'get' > output are data (except get("URL"))
			* always combine with Assert.assertEquals

			If method (hàm) have prefix 'is' > output are boolean type
			* always combine with Assert.assertTrue / False
			
			Do not register element when the browser and URL are not initialized
			* Should register right after the element is appeared (after open the browser and access to the URL contains the element)
		*/
			
		
	}
	
}