package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Radio_Button_Checkbox {
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
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Button() {
		driver.get("https://www.fahasa.com/customer/account/create");
		
		driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
		
		By loginButton = By.cssSelector("button.fhs-btn-login");
		
		// Verify login button is disabled
		Assert.assertFalse(driver.findElement(loginButton).isEnabled());
		
		// Verify login button color is grey
		String loginButtonBackground = driver.findElement(loginButton).getCssValue("background-image");
		System.out.println(driver.findElement(loginButton).getCssValue("background-image"));
		Assert.assertTrue(loginButtonBackground.contains("rgb(224, 224, 224)"));
		
		driver.findElement(By.cssSelector("input#login_username")).sendKeys("0123456789");
		driver.findElement(By.cssSelector("input#login_password")).sendKeys("12345678");
		
		// Verify login button is enabled
		Assert.assertTrue(driver.findElement(loginButton).isEnabled());

		loginButtonBackground = driver.findElement(loginButton).getCssValue("background-color");
		Color loginButtonBackgroundColor = Color.fromString(loginButtonBackground);
		Assert.assertEquals(loginButtonBackgroundColor.asHex().toUpperCase(), "#C92127");
	}

	@Test
	public void TC_02_Checkbox_Radio_Button_Single() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		
		// Select a checkbox/ radio
		driver.findElement(By.xpath("//label[contains(text(),'Diabetes')]/preceding-sibling::input")).click();
		driver.findElement(By.xpath("//label[contains(text(),\"I don't drink\")]/preceding-sibling::input")).click();
		
		// Verify checkbox/ radio have been selected
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Diabetes')]/preceding-sibling::input")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),\"I don't drink\")]/preceding-sibling::input")).isSelected());
		
		// Note: Checkbox can be undo/ Radio can't be undo
	}
	
	@Test
	public void TC_03_Checkbox_Radio_Button_Multiple() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		
		List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("form.check-box"));
		
		// Use for loop to check the condition
		for (WebElement checkbox : allCheckboxes) {
			checkbox.click();
			sleepInSecond(1);
		}
		
		// Verify all checkboxes are successfully selected
		for (WebElement checkbox : allCheckboxes) {
			Assert.assertTrue(checkbox.isSelected());
		}
		
		// Only select the checkbox with "X" in name
		for (WebElement checkbox : allCheckboxes) {
			if(checkbox.getAttribute("value").equals("Diabetes"));
			checkbox.click();
		}
	}
	
	@Test
	public void TC_04_Default_Checkbox() {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		
		// Check the condition before select the checkbox
		// The ! stand for negate the condition
		if(!driver.findElement(By.xpath("//label[text()='Rain sensor']/preceding-sibling::input")).isSelected()) {
			driver.findElement(By.xpath("//label[text()='Rain sensor']/preceding-sibling::input")).click();
		}
		if(driver.findElement(By.xpath("//label[text()='Rain sensor']/preceding-sibling::input")).isSelected()) {
			driver.findElement(By.xpath("//label[text()='Rain sensor']/preceding-sibling::input")).click();
		}
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 1000ms = 1s 
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}