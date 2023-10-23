package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_05_Parameter_Multi_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	By emailTextbox = By.xpath("//*[@id=email]");
	By passwordTextbox = By.xpath("//*[@id=pass");
	By loginButton = By.xpath("//*[@id=send2");

	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browserName) {
		// If else
		if (browserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "//browserDrivers//geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			throw new RuntimeException("Please correct the browser's name");
		}
		
		// Switch case
		switch (browserName) {
		case "FireFox": {
			System.setProperty("webdriver.gecko.driver", projectPath + "//browserDrivers//geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		case "Chrome": {
			System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers//chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		default:
			throw new IllegalArgumentException("Please correct the browser's name");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Parameters ("environment")
	@Test
	public void TC_01_LoginToSystem(String envName) {
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");

		driver.findElement(emailTextbox).sendKeys("selenium_11_01@gmail.com");
		driver.findElement(passwordTextbox).sendKeys("111111");
		driver.findElement(loginButton).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("selenium_11_01@gmail.com"));

		// Check an information or action for a task
		
		// Post-condition: Logout for the next User data can run 
		driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}