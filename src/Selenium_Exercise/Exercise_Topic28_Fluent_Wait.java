package Selenium_Exercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Exercise_Topic28_Fluent_Wait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	FluentWait<WebDriver> fluentDriver;
	FluentWait<WebElement> fluentElement;
	long totalTime = 15; // second
	long intervalTime = 100; // millisecond

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
	}

	@Test
	public void TC_01_Fluent_Wait() {
		// Use for some cases like count-down time
		// Use for cases that can not use Explicit and Implicit Wait
		driver.get("https://automationfc.github.io/fluent-wait/");
		
		WebElement cdTimer = driver.findElement(By.xpath("//div[@id='javascript_countdown_time']"));
		fluentElement = new FluentWait<WebElement>(cdTimer);
		
		fluentElement.withTimeout(Duration.ofSeconds(totalTime))
		.pollingEvery(Duration.ofMillis(intervalTime))
		.ignoring(NoSuchElementException.class);
		
		fluentElement.until(new Function<WebElement, Boolean>() {
			public Boolean apply(WebElement element) {
				String text = element.getText();
				System.out.println(text);
				return text.endsWith("00");
			}
		});
		
	}



	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}