package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Handle_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		
		driver = new FirefoxDriver();
		/* explicitWait: flexible wait
		 * Keep waiting if element not found yet > over time > failed
		 * If found, no need to wait till time out
		 */
		explicitWait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_JQuery() 
	{
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		// 1. Click on arbitrary element and wait all the items to be displayed 
		driver.findElement(By.cssSelector("span#speed-button")).click();
		
		/* 2. Wait all items loaded successfully
		 * Get the tag name presence for all items
		 * Get to the tag name contains the text in dropdown
		 */
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#speed-menu div[role='option']")));
		
		// Get all the items in dropdown into a list
		List<WebElement> speedDropdownItems = driver.findElements(By.cssSelector("ul#speed-menu div[role='option']"));
		
		// 3. Find the needed item ( using "for" loop)
		for (WebElement tempItems : speedDropdownItems) {
			String itemText = tempItems.getText();
			System.out.println(itemText);
			
			// 4. Check the item correct to the expected
			if (itemText.equals("Faster")) 
			{
				// 5. Click
				tempItems.click();
				
				// Exit from loop after the condition is satisfied
				break;
			}
		}
		
		/* presence :: visible
		 * visible: only elements in visible range
		 * presence: all elements appear in locator
		 */
		
		// 3. Find the necessary item
		
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