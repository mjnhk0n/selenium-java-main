package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_23_Wait_Element_Status {
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
		explicitWait = new WebDriverWait(driver, 10);
	}

	@Test
	public void TC_01_Visible_Displayed_Visibility() {
		driver.get("https://www.facebook.com/");
		// Displayed in UI (mandatory)
		// Presence in HTML (mandatory)

		// Wait until email address textbox is displayed
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

		driver.findElement(By.id("email")).sendKeys("automationTest@gmail.com");
	}

	@Test
	public void TC_02_Invisible_Invisibility() {
		// Not displayed in UI (mandatory)
		// Displayed in HTML
		driver.get("https://www.facebook.com/");

		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		// Wait for re-enter email textbox is not displayed in 10s
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
	}

	@Test
	public void TC_02_Invisible_Invisibility_p2() {
		// Not displayed in UI (mandatory)
		// Not displayed in HTML also (mandatory)
		driver.get("https://www.facebook.com/");

		// Wait for re-enter email textbox is not displayed in 10s
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
	}

	@Test
	public void TC_03_Presence_of_element() {
		// Contained in HTML (mandatory)
		driver.get("https://www.facebook.com/");

		// Wait for re-enter email textbox is not displayed in 10s
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.name("reg_email_confirmation__")));
	}

	@Test
	public void TC_03_Presence_of_element_p2() {
		// Does not displayed in UI
		// Contained in HTML (mandatory)
		driver.get("https://www.facebook.com/");

		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		// Wait for re-enter email textbox is not displayed in 10s
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.name("reg_email_confirmation__")));
	}

	@Test
	public void TC_04_Stalness() {
		// Not displayed in UI (mandatory)
		// Not displayed in HTML also (mandatory)
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		WebElement emailAdressTextBox = driver.findElement(By.name("reg_email_confirmation__"));
		
		driver.findElement(By.cssSelector("img._8idr")).click();
		
		// Wait for re-enter email textbox is not presence in HTML in 10s
		explicitWait.until(ExpectedConditions.stalenessOf(emailAdressTextBox));
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