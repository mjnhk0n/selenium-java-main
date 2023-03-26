package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath_Part1 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
	}

	@Test
	public void TC_01_() {
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		
		// Click vào link My Account dưới footer
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		// Cơ chế của selenium: luôn thao tác với element đầu tiên nều có nhiều hơn 1 node
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}