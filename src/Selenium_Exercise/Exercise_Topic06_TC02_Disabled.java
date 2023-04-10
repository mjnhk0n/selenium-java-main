package Selenium_Exercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_Topic06_TC02_Disabled {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	By emailTextBox = By.id("mail");
	By ageUnder18Radio = By.cssSelector("#under_18");
	By educationTextArea = By.cssSelector("#edu");
	By user5 = By.xpath("//h5[text()='Name: User5']");
	

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	

	@Test
	public void TC_02_Disable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		// Check element: Password field is disabled
		if (driver.findElement(By.cssSelector("#disable_password")).isEnabled()) {
			System.out.println("Password text box is enabled");
		} else {
			System.out.println("Password text box is disabled");
		}
		
		// Check element: Radio button is disabled 
		if (driver.findElement(By.cssSelector("#radio-disabled")).isEnabled()) {
			System.out.println("Radio button is enabled");
		} else {
			System.out.println("Radio button is disabled");
		}
		
		// Check element: Biography   
		if (driver.findElement(By.cssSelector("#bio")).isEnabled()) {
			System.out.println("Biography is enabled");
		} else {
			System.out.println("Biography is disabled");
		}
		
		// Check element: Job Role 3 - Disable dropdown
		if (driver.findElement(By.cssSelector("#job3")).isEnabled()) {
			System.out.println("Job role 3 - disable dropdown is enabled");
		} else {
			System.out.println("Job role 3 - Disable dropdown is disabled");
		}
		
		// Check element: Interest: Check box is disabled
		if (driver.findElement(By.cssSelector("#check-disbaled")).isEnabled()) {
			System.out.println("Interest: Check box is disabled is enabled");
		} else {
			System.out.println("Interest: Check box is disabled is disabled");
		}
		
		// Check element: Slider 2
		if (driver.findElement(By.cssSelector("#slider-2")).isEnabled()) {
			System.out.println("Slider 2 is enabled");
		} else {
			System.out.println("Slider 2 is disabled");
		}
		
		driver.quit();
	}
}
