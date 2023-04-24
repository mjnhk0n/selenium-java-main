package Selenium_Exercise;

import static org.testng.Assert.assertFalse;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
	public void TC_05_Rode() {
		driver.get("https://rode.com/en/support/where-to-buy");
		
		// Check if the dropdown is not supported for multiple select
		if (new Select(driver.findElement(By.cssSelector("select#country"))).isMultiple()) {
			System.out.println("This is multiple select");
		} else {
			System.out.println("This is single select");
		}

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
	
	@Test
	public void TC_06_Applitools() {
		driver.get("https://applitools.com/automating-tests-chrome-devtools-recorder-webinar/");
		
		// Fill in all mandatory fields
		driver.findElement(By.name("Email")).sendKeys("minhtn@gmail.com");
		driver.findElement(By.name("FirstName")).sendKeys("Nhat Minh");
		driver.findElement(By.name("LastName")).sendKeys("Tran");
		
		dropdownSelect("select#Person_Role__c", "select#Person_Role__c>option", "SDET / Test Automation Engineer");
		Assert.assertEquals(new Select(driver.findElement(By.id("Person_Role__c"))).getFirstSelectedOption().getText(), "SDET / Test Automation Engineer");
		
		driver.findElement(By.name("Company")).sendKeys("ABC");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		sleepInSecond(1);
		dropdownSelect("select#Test_Framework__c", "select#Test_Framework__c>option", "Selenium");
		Assert.assertEquals(new Select(driver.findElement(By.id("Test_Framework__c"))).getFirstSelectedOption().getText(), "Selenium");
		
		dropdownSelect("select#Self_Report_Country__c", "select#Self_Report_Country__c>option", "Vietnam");
		Assert.assertEquals(new Select(driver.findElement(By.id("Self_Report_Country__c"))).getFirstSelectedOption().getText(), "Vietnam");
	}
	
	public void dropdownSelect(String dropdownBox, String dropdownItems, String itemSelect) {
		driver.findElement(By.cssSelector(dropdownBox)).click();
		List<WebElement> allDropdownItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(dropdownItems)));
		for (WebElement tempItems : allDropdownItems) {
			if (tempItems.getText().trim().equals(itemSelect)) {
				tempItems.click();
				break;
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
	public void After_Class() {
		driver.quit();
	}
}
