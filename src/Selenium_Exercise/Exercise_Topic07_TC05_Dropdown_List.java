package Selenium_Exercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_Topic07_TC05_Dropdown_List {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver,30);
	}

	@Test
	public void TC_01_Rode() {
		driver.get("https://rode.com/en/support/where-to-buy");
		
		// Check if the dropdown is not supported for multiple options select

		

		// Select item Viet Nam in the dropdown and verify the item is successfully selected
		driver.findElement(By.id("country")).click();
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("country")));
		new Select(driver.findElement(By.id("country"))).selectByVisibleText("Vietnam");
		Assert.assertEquals(new Select(driver.findElement(By.id("country"))).getFirstSelectedOption().getText(),"Vietnam");
		
		sleepInSecond(2);
		
		// Get text of distributor
		List<WebElement> allText = driver.findElements(By.cssSelector("div[class='p-1']>h4"));
		for(int i = 0; i< allText.size(); i++) {
			explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='p-1']>h4")));
	        //obtain text
	        String distributorName = allText.get(i).getText();
	        System.out.println("Viet Nam Dealer's Name:" + " " + distributorName);
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
	public void After_Class() {
//		driver.quit();
	}
}
