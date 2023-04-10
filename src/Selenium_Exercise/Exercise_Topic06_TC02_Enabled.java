package Selenium_Exercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_Topic06_TC02_Enabled {
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
	public void TC_02_Enable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		// Check element: Email is enabled
		if (driver.findElement(emailTextBox).isEnabled()) {
			System.out.println("Email text box is enabled");
		} else {
			System.out.println("Email text box is not enabled");
		}
		
		// Check element: Under 18 radio button
		if (driver.findElement(ageUnder18Radio).isEnabled()) {
			System.out.println("Under 18 button is enabled");
			
		} else {
			System.out.println("Under 18 button is not enabled");
		}
		
		// Check element: Education
		if (driver.findElement(educationTextArea).isEnabled()) {
			System.out.println("Education text area is enabled");
		} else {
			System.out.println("Education text area is not enabled");
		}
		
		// Check element: Job 1 - single dropdown
		if (driver.findElement(By.cssSelector("#job1")).isEnabled()) {
			System.out.println("Job Role 01 - Single Dropdown is enabled");
		} else {
			System.out.println("Job Role 01 - Single Dropdown is not enabled");
		}
		
		// Check element: Job 2 - multiple dropdown
		if (driver.findElement(By.cssSelector("#job2")).isEnabled()) {
			System.out.println("Job Role 02 - Multiple Dropdown is enabled");
		} else {
			System.out.println("Job Role 02 - Multiple Dropdown is not enabled");
		}
		
		// Check element: Development check box
		if (driver.findElement(By.xpath("//label[@for='development']")).isEnabled()) {
			System.out.println("Development check box is enabled");
		} else {
			System.out.println("Development check box is not enabled");
		}
		
		// Check element: Slider 01
		if (driver.findElement(By.xpath("//input[@name='slider-1']")).isEnabled()) {
			System.out.println("Slider 01 is enabled");
		} else {
			System.out.println("Slider 01 is not enabled");
		}
		driver.quit();
	}
}
