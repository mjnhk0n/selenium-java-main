package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Topic_04_Data_Provider {
	WebDriver driver;
	By emailTextbox = By.xpath("//*[@id=email]");
	By passwordTextbox = By.xpath("//*[@id=pass");
	By loginButton = By.xpath("//*[@id=send2");

	@BeforeClass
	public void BeforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "login")
	public void TC_01_LoginToSystem(String username, String password) throws InterruptedException {
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");

		driver.findElement(emailTextbox).sendKeys(username);
		driver.findElement(passwordTextbox).sendKeys(password);
		driver.findElement(loginButton).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains(username));

		// Check an information or action for a task
		
		// Post-condition: Logout for the next User data can run 
		driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	}
	
	// Not good to use in real project, usually use the external file like excel/csv to save/use the data
	
	@DataProvider(name = "login")
	public Object[][] loginDataProvider() {
		return new Object[][] { 
			{ "selenium_11_01@gmail.com", "111111" }, 
			{ "selenium_11_02@gmail.com", "111111" },
			{ "selenium_11_03@gmail.com", "111111" }};
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
