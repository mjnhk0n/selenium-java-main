package webdriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Alert {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Alert alert;
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//	@Test
	public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");

		// Click button Accept alert
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

		// Wait until the alert appears to interact <~ this one should be use
		// for stable and less fail result
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());

		// Verify alert title/ content
		Assert.assertEquals(alert.getText(), "I am a JS Alert");

		// Accept
		alert.accept();

		// Verify accepted successfully
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked an alert successfully");
	}

//	@Test
	public void TC_02_Confirm_Alert() {
		// Click button Confirm alert
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

		alert = explicitWait.until(ExpectedConditions.alertIsPresent());

		// Verify alert title/ content
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");

		// Accept
		alert.dismiss();

		// Verify accepted successfully
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked: Cancel");
	}

//	@Test
	public void TC_03_Promt_Alert() {
		// Click button Accept alert
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

		alert = explicitWait.until(ExpectedConditions.alertIsPresent());

		// Verify alert title/ content
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		
		// Input any text
		alert.sendKeys("MinhTN");

		// Accept
		alert.accept();

		// Verify accepted successfully
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You entered: MinhTN");
	}

//	@Test
	public void TC_04_NetBanking() {
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
		// Click Continue button
		driver.findElement(By.cssSelector("a.btn.btn-primary.login-btn")).click();

		alert = explicitWait.until(ExpectedConditions.alertIsPresent());

		// Verify alert title/ content
		Assert.assertEquals(alert.getText(), "Customer ID  cannot be left blank.");
		
		// Accept
		alert.accept();
	}
	
	@Test
	public void TC_05_Authentication_Alert() {
		// Directly fill in the user name / password for this URL > automatically sign in
		// https://username:password@URL
		driver.get("http://the-internet.herokuapp.com/");
		
		String authenUrl = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
		
		userPasswordToURL(authenUrl, "admin", "admin");
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
		
	}
	

	@Test
	public void TC_06_Authentication_Alert_AutoIT() {
		
		
		driver.get("http://the-internet.herokuapp.com/basic_auth");
		
		// Using Auto IT only works with Windows
		// Unable to run on CI tools
		
		String authenUrl = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
		
		userPasswordToURL(authenUrl, "admin", "admin");
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
		
	}
	
	public String userPasswordToURL(String url, String userName, String password) {

		String[] arrayUrl = url.split("//");
		return arrayUrl[0] + "//" + userName + ":" + password + "@" + arrayUrl[1];
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