package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Action_part3 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	Actions act;
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		act = new Actions(driver);
		jsExecutor = (JavascriptExecutor) driver;
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Double_Click() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		// Scroll to view the element
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[text()='Double click me']")));
		sleepInSecond(1);
		
		act.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
	}

	@Test
	public void TC_02_Right_Click() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		// Right click target element
		act.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());
		
		// Hover cursor to "Quit"
		act.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
		
		// Verify element has been hovered
		Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-visible.context-menu-hover")).isDisplayed());
		
		// Click Quit
		act.click(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
		
		driver.switchTo().alert().accept();
		// Verify context menu is not displayed
		Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());
	}
	
	@Test
	public void TC_03_Drag_Drop_HTML4() {
		driver.get("https://automationfc.github.io/kendo-drag-drop/");
		
		WebElement smallCircle = driver.findElement(By.cssSelector("div#draggable"));
		WebElement dropTarget = driver.findElement(By.cssSelector("div#droptarget"));
		
		act.dragAndDrop(smallCircle, dropTarget).perform();
		
		// Verify text
		Assert.assertEquals(dropTarget.getText(), "You did great!");
		
		// Verify background color
		String dropTargetBackgroundColor = dropTarget.getCssValue("background-color");
		
		Assert.assertEquals(Color.fromString(dropTargetBackgroundColor).asHex(), "#03a9f4");
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