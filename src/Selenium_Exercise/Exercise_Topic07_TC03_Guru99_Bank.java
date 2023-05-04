package Selenium_Exercise;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_Topic07_TC03_Guru99_Bank {
	WebDriver driver;
	Random rand = new Random();
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String customerName, birthDate, address, city, state, email, password, demoUsername, demoPassword;
	String PIN = String.valueOf(rand.nextInt(999999));
	String mobileNumber = String.valueOf(rand.nextInt(99999) + rand.nextInt(99999) + rand.nextInt(99999));
	Actions act;
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) 
		{	
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		customerName = "MinhTN";
		birthDate = "12311992";
		address = "Address" + rand.nextInt(999);
		city = "Ha Noi";
		state = "Ho Hoan Kiem";
		email = "minhtn_auto@gmail.com";
		password = "123456";
		demoUsername = "mngr493427";
		demoPassword = "yvUnupu";
	}
	
	
	@Test
	public void TC_03_Guru_Bank() 
	{
		driver.get("https://demo.guru99.com/v4/");
		sleepInSecond(3);
		
		// Input given user name + Password and login
		driver.findElement(By.cssSelector("input[name='uid']")).sendKeys(demoUsername);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(demoPassword);
		WebElement btnLogin = driver.findElement(By.name("btnLogin"));
		
		btnLogin.click();
		
		sleepInSecond(1);
		
		// Verify home page is displayed
		Assert.assertTrue(driver.findElement(By.cssSelector("marquee[class='heading3']")).isDisplayed());
		
		// Click New Customer
		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
		driver.findElement(By.name("name")).sendKeys(customerName);
		
//		sleepInSecond(2);
//		driver.findElement(By.name("dob")).click();
		
		sleepInSecond(2);
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("12311992");
		
//		driver.quit();
	}
	
	
	public void sleepInSecond (long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
