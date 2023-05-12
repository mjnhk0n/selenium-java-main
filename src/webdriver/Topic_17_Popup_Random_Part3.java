package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Popup_Random_Part3 {
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
		options.addPreference("browser.cache.disk.enable", false);
		options.addPreference("browser.cache.memory.enable", false);
		options.addPreference("browser.cache.offline.enable", false);
		options.addPreference("network.http.use-cache", false);
		driver = new FirefoxDriver(options);
		explicitWait = new WebDriverWait(driver, 60);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Test
	public void TC_01_Popup_Random_in_DOM() {
		driver.get("https://www.javacodegeeks.com/");

		By emailPopup = By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none']");
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(emailPopup));
		String randomEmail = "minhtn" + randomNumber() + "@gmail.com";

		// Verify the popup's display
		if (driver.findElement(emailPopup).isDisplayed()) {
			// Input the email
			By emailTextBox = By.cssSelector("div.lepopup-input>input[type='email']");
			
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(emailTextBox));
			
			driver.findElement(emailTextBox).sendKeys(randomEmail);
			
			// Click OK
			driver.findElement(By.cssSelector("a[data-label='Get the Books'],[data-label='OK']>span")).click();
			
			explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.lepopup-element-html-content")));
			
			// Verify the successful message popup
			Assert.assertEquals(driver.findElement(By.cssSelector("div.lepopup-element-html-content>h4")).getText(), "Thank you!");
			Assert.assertTrue(driver.findElement(By.cssSelector("div.lepopup-element-html-content>p")).getText().contains("Your sign-up request was successful."));
		}
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.lepopup-element-html-content>h4")));
		
		String articleName = "Agile Testing Explained";
		// Search with keyword: Agile testing explained
		driver.findElement(By.id("search-input")).sendKeys(articleName);
		driver.findElement(By.id("search-submit")).click();

		// Verify the first article contains the keyword
		Assert.assertEquals(driver.findElement(By.cssSelector("ul#posts-container>li:first-child>div>h2>a")).getText(), articleName);
	}

	@Test
	public void TC_02_Popup_Not_in_DOM_Facebook() {
		
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 1000ms = 1s
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}