package Selenium_Exercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_Topic25_Explicit_Wait {
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
	}

	@Test
	public void TC_01_Ajax_Loading() {
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		
		List<WebElement> dateTimePicker	= driver.findElements(By.cssSelector("tr.rcRow>td"));
		
		boolean selected = false;
		
		for (WebElement dateDisplayed : dateTimePicker) {
			if (dateDisplayed.isSelected()) {
				System.out.println("Tuesday, Jul 11, 2023");
				selected = true;
			} 
		}
		
		if (!selected) {
			System.out.println("No Selected Dates to display");
		}
		
		explicitWait = new WebDriverWait(driver, 5);
		
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='rcSelected']//a[text()='11']")));
		
		driver.findElement(By.xpath("//a[text()='11']")).click();
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));
		
		explicitWait.until(ExpectedConditions.elementToBeSelected(By.xpath("//td[@class='rcSelected']//a[text()='11']")));
		
		for (WebElement dateDisplayed : dateTimePicker) {
			if (dateDisplayed.isSelected()) {
				System.out.println("Tuesday, Jul 11, 2023");
				selected = true;
			} 
		}
		
		if (!selected) {
			System.out.println("No Selected Dates to display");
		}
	}
	
	
//	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}