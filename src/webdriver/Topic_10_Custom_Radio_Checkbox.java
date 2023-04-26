package webdriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Custom_Radio_Checkbox {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		
		driver = new FirefoxDriver();
		
		// Always initialization after driver variable
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	public void TC_01() {
		driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");
		
		/*	Case 1	*/
		// Input tag is obscured > unable to click
		// Can be use to verify > isSelected() method only works with Input
		
		// Select
		driver.findElement(By.xpath("//div[text()='Register for your relative']/preceding-sibling::div/input")).click();
		
		// Verify selected successfully
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Register for your relative']/preceding-sibling::div/input")).isSelected());
	}

	
	public void TC_02() {
		/*	Case 2	*/
		// Use tag other than Input to click (span/div/label/...)
		// Can NOT be use to verify > isSelected() method only works with Input
		
		// Select
		driver.findElement(By.xpath("//div[text()='Register for your relative']/preceding-sibling::div")).click();
		
		// Verify selected successfully
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Register for your relative']/preceding-sibling::div")).isSelected());
	}

	@Test
	public void TC_03() {
		/*	Case 3	*/
		// Use tag other than Input to click
		// Use Input tag to verify
		
		// Select
		driver.findElement(By.xpath("//div[text()='Register for your relative']/preceding-sibling::div")).click();
		
		// Verify selected successfully
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Register for your relative']/preceding-sibling::div/input")).isSelected());
	}
	
	/* Above case can be used to demo/ basic 
	 * Do not apply to a framework or real project
	 * Because 1 element is used to define to many locators (confuse/ hard to maintain)
	 */
	
	@Test
	public void TC_04() {
		/*	Case 4	*/
		// Use Input tag to click even it hidden
		// click() method of WebElement is unable to click on hidden element
		// Use click() method of JavaScript
		// Selenium provide a library to embedded the JS code to test script -> JavascriptExecutor 
		
		By radioButton = By.xpath("//div[text()='Register for your relative']/preceding-sibling::div/input");
		
		// Select
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(radioButton));
		
		// Verify selected successfully
		Assert.assertTrue(driver.findElement(radioButton).isSelected());
	}
	
	@Test
	public void TC_05() {
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		sleepInSecond(2);
		
		// Verify "Cần Thơ" button is not selected
		By buttonCanTho = By.cssSelector("div[data-value='Cần Thơ']");
		By checkboxQuangNgai = By.cssSelector("div[data-value='Quảng Ngãi']");
		Assert.assertEquals(driver.findElement(buttonCanTho).getAttribute("aria-checked"), "false");
		
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(buttonCanTho));
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(checkboxQuangNgai));
		// Verify selected successfully (1)
		Assert.assertEquals(driver.findElement(buttonCanTho).getAttribute("aria-checked"), "true");
		Assert.assertEquals(driver.findElement(checkboxQuangNgai).getAttribute("aria-checked"), "true");
		
		// Verify selected successfully (2)
		Assert.assertTrue(driver.findElement(By.cssSelector("div[data-value='Cần Thơ'][aria-checked='true']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("div[data-value='Quảng Ngãi'][aria-checked='true']")).isDisplayed());
		
		// This case is rare to meet
		// Application of big tech site like Google/Facebook/... should not use Automation test on it ( should be automation register or other actions)
	}
	
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 1000ms = 1s 
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}