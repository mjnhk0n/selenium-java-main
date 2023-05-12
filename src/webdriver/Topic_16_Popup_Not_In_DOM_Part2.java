package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Popup_Not_In_DOM_Part2 {
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


//	@Test
	public void TC_01_Popup_Not_in_DOM_Tiki() {
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
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Email không được để trống']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Mật khẩu không được để trống']")).isDisplayed());

		sleepInSecond(1);

		// Close the popup
		driver.findElement(By.cssSelector("img.close-img")).click();

		// Verify popup is closed
		Assert.assertEquals(driver.findElements(tikiLoginPopup).size(), 0);
	}
	
	@Test
	public void TC_02_Popup_Not_in_DOM_Facebook() {
		driver.get("https://www.facebook.com/");

		By fbLoginPopup = By.xpath("//div[text()='Sign Up']/parent::div/parent::div");

		// Verify popup is not displayed
		Assert.assertEquals(driver.findElements(fbLoginPopup).size(), 0);

		// Click Account button
		driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();

		// Verify popup is displayed
		Assert.assertTrue(driver.findElement(fbLoginPopup).isDisplayed());
		
		sleepInSecond(1);
		
		// Close the popup
		driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();

		// Verify popup is closed
		Assert.assertEquals(driver.findElements(fbLoginPopup).size(), 0);
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