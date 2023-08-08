package webdriver;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.TimeoutException;

public class Topic_26_Mix_Explicit_Implicit_Wait {
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

//	@Test
	public void TC_01_Element_Found() {
		// Element is appeared and no need to wait timeout
		// Set both of Wait is not affected
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 10);
		
		// Implicit Wait: Only apply for findElement/Elements
		// Explicit Wait: Apply for all other conditions of Element
		driver.get("https://facebook.com/");
		
		// Explicit
		System.out.println("Start time of explicit: " + getTimeStamp());
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
		System.out.println("End time of explicit: " + getTimeStamp());
		
		// Implicit
		System.out.println("Start time of implicit: " + getTimeStamp());
		driver.findElement(By.cssSelector("input#email"));
		System.out.println("End time of implicit: " + getTimeStamp());
	}
	
	
//	@Test
	public void TC_02_Element_Not_Found() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://facebook.com/");
		
		System.out.println("Start time of implicit: " + getTimeStamp());
		try {
			driver.findElement(By.cssSelector("input#notfound"));
		} catch (Exception e) {
			// Block the exception action and run the command in "catch"
			System.out.println("End time of implicit: " + getTimeStamp());
		}
	}
	
//	@Test
	public void TC_03_Element_Not_Found_Implicit_Explicit() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://facebook.com/");
		// Implicit = Explicit
		// Implicit > Explicit
		// Implicit < Explicit
		
		// Implicit
		System.out.println("Start time of implicit: " + getTimeStamp());
		try {
			driver.findElement(By.cssSelector("input#notfound"));
		} catch (Exception e) {
			// Block the exception action and run the command in "catch"
			System.out.println("End time of implicit: " + getTimeStamp());
		}
		
		// Explicit
		explicitWait = new WebDriverWait(driver, 5);
		System.out.println("Start time of Explicit: " + getTimeStamp());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#notfound")));
		} catch (NoSuchElementException nosuchException) {
			// Block the exception action and run the command in "catch"
			System.out.println("End time of Explicit: " + getTimeStamp());
		}
	}
	
	
	@Test
	public void TC_04_Element_Not_Found_Explicit_By() {
		driver.get("https://facebook.com/");
		
		// Explicit
		explicitWait = new WebDriverWait(driver, 5);
		System.out.println("Start time of Explicit: " + getTimeStamp());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#notfound")));
		} catch (NoSuchElementException nosuchException) {
			// Block the exception action and run the command in "catch"
			System.out.println("End time of Explicit: " + getTimeStamp());
		}
	}
	
	@Test
	public void TC_05_Element_Not_Found_Explicit_Element() {
		driver.get("https://facebook.com/");
		
		// Explicit
		explicitWait = new WebDriverWait(driver, 5);
		System.out.println("Start time of Explicit: " + getTimeStamp());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#notfound")));
		} catch (NoSuchElementException nosuchException) {
			// Block the exception action and run the command in "catch"
			System.out.println("End time of Explicit: " + getTimeStamp());
		}
	}
	
	@Test
	public void TC_06_In_Real_Project() {
		driver.get("https://facebook.com/");
		
		// Wait 
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#email"))));
		
		// Action
		driver.findElement(By.cssSelector("input#email")).sendKeys("abc");
		
	}
	
	
	private String getTimeStamp() {
		Date date = new Date();
		return date.toString();
	}

	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}