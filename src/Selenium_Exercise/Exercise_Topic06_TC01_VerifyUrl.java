package Selenium_Exercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_Topic06_TC01_VerifyUrl {
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
	public void TC_01_Check_Display() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		// Check element: email text box
		if (driver.findElement(emailTextBox).isDisplayed()) {
			driver.findElement(emailTextBox).sendKeys("Automation Testing");
			System.out.println("Email text box is displayed");
		} else {
			System.out.println("Email text box is not displayed");
		}
		
		// Check element: Age: under 18 Radio button
		if (driver.findElement(ageUnder18Radio).isDisplayed()) {
			driver.findElement(ageUnder18Radio).click();
		} else {
			System.out.println("Age (under 18) button is not displayed ");
		}
		
		// Check element: Education text box
		if (driver.findElement(educationTextArea).isDisplayed()) {
			driver.findElement(educationTextArea).sendKeys("Automation Testing");
			System.out.println("Education text box is displayed");
		} else {
			System.out.println("Education text box is not displayed");
		}
		
		// Check element: User 5
		if (driver.findElement(user5).isDisplayed()) {
			System.out.println("User 5 is displayed");
		} else {
			System.out.println("User 5 is not displayed");
		}
		driver.quit();
	}
}
