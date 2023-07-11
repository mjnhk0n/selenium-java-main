package webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_24_FindElement_FindElements {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 10);
	}

	@Test
	public void TC_01_findElement() {
		// Find only 1 element/node
		// Directly manipulate to that element/node > find out so dont need to
		// wait for 15s
		driver.findElement(By.cssSelector("input#email")).clear();

		// If found more than 1 element/node
		// It will manipulate the first element/node and ignore the rest
		// Wrong locator > wrong element > can't act
		driver.findElement(By.cssSelector("input#email")).sendKeys("123@gmail.com");

		// Can not find an element/node
		// Re-find each 0.5s
		// Found in wait time (10s) > pass
		// Can't find in wait time (10s) > Fail this step or throw an exception:
		// NoSuchElementException

	}

	@Test
	public void TC_02_findElements() {
		// Find only 1 element/node
		// Directly manipulate to that element/node > find out so dont need to
		// wait for 15s
		driver.findElement(By.cssSelector("input#email")).clear();

		// If found more than 1 element/node
		// It will manipulate the first element/node and ignore the rest
		// Wrong locator > wrong element > can't act
		driver.findElement(By.cssSelector("input#email")).sendKeys("123@gmail.com");

		// Can not find an element/node
		// Re-find each 0.5s
		// Found in wait time (10s) > pass
		// Can't find in wait time (10s)
		// + Does not fail the test case and continue running the next step
		// + Return an empty list ( list = 0 )
		
		

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}