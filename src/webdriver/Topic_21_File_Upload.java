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

public class Topic_21_File_Upload {
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

//	@Test
	public void TC_01_Single_File_Upload() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		// Load file
		inputSingleFile("files[]", imageBird);
		
		// Verify file loaded successfully
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + imageBird + "']")).isDisplayed());
		sleepInSecond(1);
		
		// Upload individual file ( for 1 file upload only)
		driver.findElement(By.xpath("//span[text()='Start']")).click();
		
		// Verify Uploaded successfully (link)
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + imageBird + "']")).isDisplayed());
		sleepInSecond(2);
		
		// Verify uploaded successfully (image)
		Assert.assertTrue(isImageLoaded("//tr//img[contains(@src,'imageBird.jpg')]"));
	}
	
	@Test
	public void TC_02_Multiple_File_Upload() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.navigate().refresh();
		
		// Load files
		inputSingleFile("files[]", imageBird);
		inputSingleFile("files[]", imageOtter);
		inputSingleFile("files[]", imageTiger);
		sleepInSecond(2);
		
		// Verify file loaded successfully
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + imageBird + "']")).isDisplayed());
		sleepInSecond(1);
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + imageOtter + "']")).isDisplayed());
		sleepInSecond(1);
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + imageTiger + "']")).isDisplayed());
		sleepInSecond(1);
		
		// Click start of each image
		List<WebElement> startButtons = driver.findElements(By.xpath("//span[text()='Start']"));
		for (WebElement start : startButtons) {
			start.click();
			sleepInSecond(2);
		}
		
		// Verify Uploaded successfully (link)
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + imageBird + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + imageOtter + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + imageTiger + "']")).isDisplayed());
		
		// Verify uploaded successfully (image)
		Assert.assertTrue(isImageLoaded("//tr//img[contains(@src,'imageBird.jpg')]"));
		sleepInSecond(2);
		Assert.assertTrue(isImageLoaded("//tr//img[contains(@src,'imageOtter.jpg')]"));
		sleepInSecond(2);
		Assert.assertTrue(isImageLoaded("//tr//img[contains(@src,'imageTiger.jpg')]"));
		sleepInSecond(2);
		
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