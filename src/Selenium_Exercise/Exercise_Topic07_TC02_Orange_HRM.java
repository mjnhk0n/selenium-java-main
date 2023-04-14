package Selenium_Exercise;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_Topic07_TC02_Orange_HRM {
	WebDriver driver;
	Random rand = new Random();
	String projectPath	= System.getProperty("user.dir");
	String osName		= System.getProperty("os.name");
	String firstName, lastName, password, userName;
	String employeeID	= String.valueOf(rand.nextInt(9999));
	String passportNumber = String.valueOf(rand.nextInt(99999) + "-" + (rand.nextInt(999) + "-" + (rand.nextInt(99) + "-" + (rand.nextInt(99)))));
	Actions act;
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) 
		{	
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		
		driver 			= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		act 			= new Actions(driver);
		firstName		= "Minh";
		lastName		= "Tran";
		userName		= "automation_exc" + rand.nextInt(999);
		password 		= "AAAaaa1@";
		

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	
	@Test
	public void TC_02_Orange_HRM() 
	{
		// Login with admin account
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		
		// Go to PIM page >  Add employee
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Add Employee')]")).click();
		
		// Fill in valid data for Employee
		driver.findElement(By.name("firstName")).sendKeys(firstName);
		driver.findElement(By.name("lastName")).sendKeys(lastName);
		driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
		
		sleepInSecond(2);
		
		driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).sendKeys(employeeID);

		sleepInSecond(2);
		
		// Click Create Login Details
		driver.findElement(By.cssSelector("div[class='oxd-switch-wrapper'] label span")).click();
		
		// Fill in User + Password + Confirm Password > Save
		driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input[@class='oxd-input oxd-input--active']")).sendKeys(userName);
		driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input[@class='oxd-input oxd-input--active']")).sendKeys(password);
		driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input[@class='oxd-input oxd-input--active']")).sendKeys(password);
		
		driver.findElement(By.cssSelector("div>button[type='submit']")).click();
	
		sleepInSecond(3);
		
		// Verify input data in Add employee are correctly displayed
		Assert.assertEquals(driver.findElement(By.name("firstName")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.name("lastName")).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"), employeeID);
		
		// Click Immigration tab
		driver.findElement(By.xpath("//a[text()='Immigration']")).click();
		
		// Add Assigned Immigration Record
		driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/parent::div//i")).click();
		driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(passportNumber);
		driver.findElement(By.xpath("//textarea")).sendKeys("This is a comment!");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		sleepInSecond(3);
		
		// Click on Edit button
		driver.findElement(By.cssSelector("i[class='oxd-icon bi-pencil-fill']")).click();
		
		sleepInSecond(3);
		
		// Verify submitted data are correct
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"), passportNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//textarea")).getAttribute("value"), "This is a comment!");
				
		// Logout
		driver.findElement(By.cssSelector("span[class='oxd-userdropdown-tab']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		sleepInSecond(3);
		
		
		
		// Relog
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		// Go to My Info > Verify First/Last name and ID
		driver.findElement(By.xpath("//span[text()='My Info']")).click();
		
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.name("firstName")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.name("lastName")).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"), employeeID);
		
		// Go to Immigration > Click Edit
		driver.findElement(By.xpath("//a[text()='Immigration']")).click();
		driver.findElement(By.cssSelector("i[class='oxd-icon bi-pencil-fill']")).click();
		
		sleepInSecond(3);
		
		// Verify saved immigration data ( number + comment)
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"), passportNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//textarea")).getAttribute("value"), "This is a comment!");
		
		// Done
		driver.quit();
	}
	
	
	
	public void sleepInSecond (long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
