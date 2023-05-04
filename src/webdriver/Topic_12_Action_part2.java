package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Action_part2 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	Actions act;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		act = new Actions(driver);
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Click_And_Hold() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		List<WebElement> listElement = driver.findElements(By.cssSelector("ol#selectable>li"));
		
		// Click on number 1 (source)
		// Hold
		act.clickAndHold(listElement.get(0))
			// Move to target number
			.moveToElement(listElement.get(7))
				// Release the left click
				.release()
					// Perform the action
					.perform();
		
		List<WebElement> listSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
		
		Assert.assertEquals(listSelected.size(), 8);
	}

	@Test
	public void TC_02_Click_and_hold_random() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		List<WebElement> listElement = driver.findElements(By.cssSelector("ol#selectable>li"));
		
		// Run for both MAC and Window
		Keys key = null;
		
		if(osName.contains("Windows")) {
			key = Keys.CONTROL;
		} else {
			key = Keys.COMMAND;
		}
		
		// Press Ctrl button
		act.keyDown(key).perform();
		
		// Select random number
		act.click(listElement.get(0))
		.click(listElement.get(2))
		.click(listElement.get(6))
		.click(listElement.get(10)).perform();
		
		// Release Ctrl button
		act.keyUp(key).perform();
		
		List<WebElement> listSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
		
		// Verify
		Assert.assertEquals(listSelected, 4);
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