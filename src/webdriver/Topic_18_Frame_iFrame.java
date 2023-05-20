package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_18_Frame_iFrame {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Kyna_iFrame() {
		driver.get("https://skills.kynaenglish.vn/");
		
		// Verify facebook iframe's display
		Assert.assertTrue(driver.findElement(By.xpath("//iframe[contains(@src,'kyna.vn')]")).isDisplayed());
		
		// Switch to facebook iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'kyna.vn')]")));
		
		// Verify Likes number of Facebook page
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Kyna.vn']/parent::div/following-sibling::div")).getText(), "164K likes");
		
		// Click chat iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'webchat.caresoft.vn')]")));
		sleepInSecond(2);
		driver.findElement(By.cssSelector("div.button_bar")).click();
		
		// Fill in the data in each field
		driver.findElement(By.cssSelector("input.input_name")).sendKeys("automation");
		driver.findElement(By.cssSelector("input.input_phone")).sendKeys("0123456789");
		selectItemInDropdown("select#serviceSelect", "select#serviceSelect>option", "TƯ VẤN TUYỂN SINH");
		driver.findElement(By.name("message")).sendKeys("Java Bootcamp");
		
		// Switch back to main page
		driver.switchTo().defaultContent();
		
		// Find search bar and perform search
		driver.findElement(By.id("live-search-bar")).sendKeys("excel");
		driver.findElement(By.cssSelector("button.search-button")).click();
		sleepInSecond(5);
		
		// Verify result contains "excel"
		List<WebElement> courseName = driver.findElements(By.cssSelector("div.content>h4"));
		for (WebElement courseList : courseName) {
			Assert.assertTrue(courseList.getText().contains("Excel"));
		}
	}

	@Test
	public void TC_02_HDFC_Bank_Frame() {
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
		// Switch frame
		driver.switchTo().frame(driver.findElement(By.name("login_page")));
		
		// Fill in the Customer ID
		driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("MinhTN");
		driver.findElement(By.cssSelector("a.login-btn")).click();
		sleepInSecond(5);
		
		// Switch back to the main page
		driver.switchTo().defaultContent();
		
		// Verify the password field is displayed
		Assert.assertTrue(driver.findElement(By.cssSelector("hdfc-specialchar[control='mainCtrl.passwordControl']")).isDisplayed());
	}

	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 1000ms = 1s 
	}
	
	
	public void selectItemInDropdown(String parentCss, String allItemCss, String expectedTextItem) {
		driver.findElement(By.cssSelector(parentCss)).click();
		List<WebElement> dropdownItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(allItemCss)));
		for (WebElement tempItem : dropdownItems) {
			if (tempItem.getText().trim().equals(expectedTextItem)) {
				tempItem.click();
				break;
				// Trim() > remove the space from leading or trailing text
				}
			}
		}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}