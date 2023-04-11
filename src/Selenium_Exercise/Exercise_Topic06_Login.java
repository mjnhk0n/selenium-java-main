package Selenium_Exercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_Topic06_Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	By userNameTextbox = By.cssSelector("input[title='Email Address']");
	By passwordTextbox = By.cssSelector("#pass");
	By loginButton = By.cssSelector("#send2");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://live.techpanda.org/");
		sleepInSecond(3);
	}

	@Test
	public void TC_01_Empty_Data() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

		// Login with empty data
		driver.findElement(loginButton).click();

		// Verify error message under User name and Password field
		Assert.assertEquals(driver.findElement(By.cssSelector("#advice-required-entry-email")).getText(),"This is a required field.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#advice-required-entry-pass")).getText(),"This is a required field.");
	}

		
	@Test
	public void TC_02_Invalid_Email() {
		// Login with invalid Email
		driver.findElement(userNameTextbox).sendKeys("12345@21234");
		driver.findElement(passwordTextbox).sendKeys("1234567");
		driver.findElement(loginButton).click();

		// Verify suggest message under User name
		Assert.assertEquals(driver.findElement(By.cssSelector("#advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
		
		driver.findElement(userNameTextbox).clear();
		driver.findElement(passwordTextbox).clear();
	}

	
	@Test
	public void TC_03_Invalid_Password() {
		// Login with password < 6
		driver.findElement(userNameTextbox).sendKeys("minhtn@automation.com");
		driver.findElement(passwordTextbox).sendKeys("123");
		driver.findElement(loginButton).click();

		// Verify suggest message under password
		Assert.assertEquals(driver.findElement(By.cssSelector("#advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
		
		driver.findElement(userNameTextbox).clear();
		driver.findElement(passwordTextbox).clear();
	}
	
	
	@Test
	public void TC_04_Incorrect_Data() {
		// Login with incorrect Email/Password
		driver.findElement(userNameTextbox).sendKeys("minhtn@automation.com");
		driver.findElement(passwordTextbox).sendKeys("1234567");
		sleepInSecond(1);
		driver.findElement(loginButton).click();
		
		// Verify error message for incorrect data
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Invalid login or password.')]")).getText(),"Invalid login or password.");
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
	public void After_Class() {
		driver.quit();
	}
}
