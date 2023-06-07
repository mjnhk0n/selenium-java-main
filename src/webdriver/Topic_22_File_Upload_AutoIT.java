package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_22_File_Upload_AutoIT {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	
	String imageBird = "imageBird.jpg";
	String imageOtter = "imageOtter.jpg";
	String imageTiger = "imageTiger.jpg";
	
	JavascriptExecutor jsExecutor;
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 15);
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Upload_Using_AutoIT() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
	}
	
	@Test
	public void TC_02_Multiple_File_Upload() {

	}

	
	public void inputSingleFile(String webElement, String imageName) {
		WebElement fileInputButton = driver.findElement(By.name(webElement));
		String filePath = projectPath + "\\uploadFiles\\" + imageName;
		fileInputButton.sendKeys(filePath);
	}
	
	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}
	
	public boolean isImageLoaded(String locator) {
		boolean status = (Boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
		return status;
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 1000ms = 1s 
	}
	
//	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}