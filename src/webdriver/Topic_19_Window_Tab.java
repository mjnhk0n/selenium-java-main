package webdriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Window_Tab {
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

//	@Test
	public void TC_01_Switch_Window_Using_ID() {
		driver.get("https://automationfc.github.io/basic-form/index.html");

		// Get window ID
		String parentPageID = driver.getWindowHandle();

		// Click Google link
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();

		// Case 1: Have 2 windows/tabs
		Set<String> allIDs = driver.getWindowHandles();

		/*
		 * Use for loop > if the current page ID is different from the parent
		 * page ID then switch to the other ID
		 */
		for (String ID : allIDs) {
			if (!ID.equals(parentPageID)) {
				driver.switchTo().window(ID);
				sleepInSecond(2);
			}
		}

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com.vn/");

		// Switch back to parent window
		String ggPageID = driver.getWindowHandle();
		/*
		 * ggPageID is different from the parent page ID > switch back to parent
		 * page ID
		 */
		switchWindowID(ggPageID);
	}
	
	@Test
	public void TC_02_Switch_Window_Using_Title () {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		// Get parent page ID
		String automationFCPageID = driver.getWindowHandle();
		String parentPageTitle = "Selenium WebDriver";
		
		// Click Google link
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		
		// Switch to Google tab
		switchWindowTitle("Google");
		
		// Switch back to parent page
		switchWindowTitle(parentPageTitle);
		
		// Click Facebook link
		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
		
		// Switch to Facebook tab
		switchWindowTitle("Facebook – log in or sign up");
		sleepInSecond(2);
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("password123");
		
		// Switch back to parent page
		switchWindowTitle(parentPageTitle);
		
		// Click Tiki
		driver.findElement(By.xpath("//a[text()='TIKI']")).click();
		
		// Switch to Tiki tab
		switchWindowTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
		
		// Close all window except parent window
		closeWindowNotParent(automationFCPageID);
	}

	public void switchWindowID(String targetWindowID) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String ID : allIDs) {
			if (!ID.equals(targetWindowID)) {
				driver.switchTo().window(ID);
				sleepInSecond(2);
			}
		}

	}

	public void switchWindowTitle(String targetWindowTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String ID : allWindowIDs) {
			// Switch to get title of each window
			driver.switchTo().window(ID);
			String currentPageTitle = driver.getTitle();

			if (currentPageTitle.equals(targetWindowTitle)) {
				break;
			}
			sleepInSecond(2);
		}
	}

	public void closeWindowNotParent(String parentWindow) {
		Set<String> allWindowID = driver.getWindowHandles();
		
		for (String ID : allWindowID) {
			if (!ID.equals(parentWindow)) {
				driver.switchTo().window(ID);
				driver.close();
			}
		}
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