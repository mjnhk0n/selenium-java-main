package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_15_Popup_Dialog_Part1 {
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
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Popup_Fixed_In_DOM() {
		driver.get("https://ngoaingu24h.vn/");
		
		By loginPopup = By.xpath("//div[@id='modal-login-v1' and @style]");
		
		// Verify popup is not displayed
		Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
		
		// Click on Login
		driver.findElement(By.cssSelector("button[class='login_ icon-before']")).click();
		
		// Verify popup is displayed
		Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
		
		// Fill in incorrect account
		driver.findElement(By.cssSelector("div.modal.fade.in div.modal-content input#account-input")).sendKeys("automationfc");
		driver.findElement(By.cssSelector("div.modal.fade.in div.modal-content input#password-input")).sendKeys("automationfc");
		
		// Click login
		driver.findElement(By.cssSelector("div.modal.fade.in div.modal-content button.btn-login-v1")).click();
		
		// Verify message Account does not exist
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Tài khoản không tồn tại!']")).getText(), "Tài khoản không tồn tại!");
		
		// Close the popup
		driver.findElement(By.cssSelector("div.modal.fade.in div.modal-content button.close")).click();
		
		// Verify the popup is closed ( not displayed)
		Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
	}

	@Test
	public void TC_02_() {
	}

	@Test
	public void TC_03_() {
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