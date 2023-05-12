package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
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

		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(new FirefoxProfile());
		options.addPreference("dom.webnotifications.enabled", false);
		options.addPreference("geo.enabled", false);
		options.addPreference("geo.provider.use_corelocation", false);
		options.addPreference("geo.prompt.testing", false);
		options.addPreference("geo.prompt.testing.allow", false);
		driver = new FirefoxDriver(options);
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// @Test
	public void TC_01_Popup_Fixed_In_DOM() {
		driver.get("https://ngoaingu24h.vn/");

		By loginPopup = By.xpath("//footer/preceding::div[@id='modal-login-v1']//div[@class='modal-content']");

		// Verify popup is not displayed
		Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());

		// Click on Login
		driver.findElement(By.cssSelector("button.login_")).click();

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

	// @Test
	public void TC_02_Kyna() {
		driver.get("https://skills.kynaenglish.vn/");

		By kynaLoginPopup = By.cssSelector("div#k-popup-account-login");

		// Verify login button is not displayed at first
		Assert.assertFalse(driver.findElement(kynaLoginPopup).isDisplayed());

		// Click login button
		driver.findElement(By.cssSelector("a.login-btn")).click();

		// Verify login popup is displayed
		Assert.assertTrue(driver.findElement(kynaLoginPopup).isDisplayed());

		// Input invalid data
		driver.findElement(By.id("user-login")).sendKeys("automation@gmail.com");
		driver.findElement(By.id("user-password")).sendKeys("123456");

		// Click login
		driver.findElement(By.id("btn-submit-login")).click();
		sleepInSecond(2);

		// Verify displayed message
		Assert.assertEquals(driver.findElement(By.id("password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");

		// Click close button
		driver.findElement(By.cssSelector("button.k-popup-account-close")).click();

		// Verify login button is closed
		Assert.assertFalse(driver.findElement(kynaLoginPopup).isDisplayed());
	}

	@Test
	public void TC_03_Popup_Not_in_DOM_Tiki() {
		driver.get("https://tiki.vn/");

		By tikiLoginPopup = By.cssSelector("div.ReactModal__Content");

		// Verify popup is not displayed
		Assert.assertEquals(driver.findElements(tikiLoginPopup).size(), 0);

		// Click Account button
		driver.findElement(By.xpath("//div[@data-view-id='header_header_account_container']")).click();

		// Verify popup is displayed
		Assert.assertTrue(driver.findElement(tikiLoginPopup).isDisplayed());

		// Click login with Email
		driver.findElement(By.cssSelector("p.login-with-email")).click();

		// Click login
		driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

		// Verify error message is displayed
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Email không được để trống']")).getText(), "Email không được để trống");
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Mật khẩu không được để trống']")).getText(), "Mật khẩu không được để trống");

		sleepInSecond(1);

		// Close the popup
		driver.findElement(By.cssSelector("img.close-img")).click();

		// Verify popup is closed
		Assert.assertEquals(driver.findElements(tikiLoginPopup).size(), 0);
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