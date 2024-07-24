package webdriver;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;

import com.google.common.base.Function;

public class Topic_28_Fluent_Wait {
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
		driver.get("https://automationfc.github.io/dynamic-loading/");

		// Wait for Start button to be displayed
		fluentDriver = new FluentWait<WebDriver>(driver);
		// Set total time and interval
		fluentDriver.withTimeout(Duration.ofSeconds(15))
				// Interval each 1/3 second
				.pollingEvery(Duration.ofMillis(333))
				// Ignoring exception for bypass fail result
				.ignoring(NoSuchElementException.class);
		// Apply the conditions
		fluentDriver.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("div#start>button"));
			}
		});

		// Save as a variable
		WebElement startButton = fluentDriver.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("div#start>button"));
			}
		});
		startButton.click();
	}

	@Test
	public void TC_02_Fluent_Wait_Variable_Use() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		findElement("//button[text()='Start']").click();
		Assert.assertEquals(findElement("//div[@id='finish']/h4").getText(), "Hello World!");
	}

	public WebElement findElement(String xpathLocator) {
		fluentDriver = new FluentWait<WebDriver>(driver);
		fluentDriver.withTimeout(Duration.ofSeconds(totalTime))
			.pollingEvery(Duration.ofMillis(intervalTime))
				.ignoring(NoSuchElementException.class);
		return fluentDriver.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(xpathLocator));
			}
		});
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}