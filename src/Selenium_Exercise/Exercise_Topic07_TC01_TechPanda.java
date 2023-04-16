package Selenium_Exercise;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_Topic07_TC01_TechPanda {
	WebDriver driver;
	Random rand;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String emailAdress, firstName, lastName, password, fullName;

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
		rand = new Random();
		emailAdress = "minhtn" + rand.nextInt(9999) + "@gmail.com";
		firstName = "Minh";
		lastName = "Tran";
		fullName = firstName + " " + lastName;
		password = "123456";
		
	}
	
	
	@Test
	public void TC_01_Check_Display() 
	{
		// Go to Create account page
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		// Fill in valid data in all fields ( create random email)
		driver.findElement(By.cssSelector("#firstname")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#lastname")).sendKeys(lastName);
		driver.findElement(By.cssSelector("#email_address")).sendKeys(emailAdress);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.cssSelector("#confirmation")).sendKeys(password);
		
		// Click register button
		driver.findElement(By.xpath("//span[text()='Register']")).click();
		
		// Verify account successfully created message
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).getText(), "Thank you for registering with Main Website Store.");
		String contactInformationText = driver.findElement(By.xpath("//h3[text()='Contact Information']//parent::div/following-sibling::div")).getText();

		System.out.println(contactInformationText);

		Assert.assertTrue(contactInformationText.contains(fullName));
		Assert.assertTrue(contactInformationText.contains(emailAdress));
		
		// Log out and verify come back to login page
		driver.findElement(By.xpath("//div[@class='page-header-container']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(@src,logo.png)]")).isDisplayed());
		
		
		// Assert absolute result
		
//		String[] array = contactInformationText.split("\\\n");
//		String name = array[0];
//		String email = array[1];
//		Assert.assertEquals(name, fullName);
//		Assert.assertEquals(email, emailAdress);
		
		//Assert.assertEquals(, false)
		driver.quit();
	}
}
