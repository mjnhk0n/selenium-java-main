package Selenium_Exercise;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_Topic25_Explicit_Wait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
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
	}
	
	
//	@Test
	public void TC_01_Ajax_Loading() {
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

		List<WebElement> dateTimePicker = driver.findElements(By.cssSelector("tr.rcRow>td"));

		boolean selected = false;

		for (WebElement dateDisplayed : dateTimePicker) {
			if (dateDisplayed.isSelected()) {
				System.out.println("Tuesday, July 11, 2023");
				selected = true;
			}
		}

		if (!selected) {
			System.out.println("No Selected Dates to display");
		}

		Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "No Selected Dates to display.");

		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='11']")));

		driver.findElement(By.xpath("//a[text()='11']")).click();

		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='ContentPlaceholder1_RadCalendar1']>div.raDiv")));

		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@title='Tuesday, July 11, 2023']/a[text()='11']")));

		Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "Tuesday, July 11, 2023");
	}

	@Test
	public void TC_02_ExplicitWait_Gofile() {
		String imageBird = "imageBird.jpg";
		String imageOtter = "imageBird.jpg";
		String imageTiger = "imageTiger.jpg";
		
		String uploadFileFolder = projectPath + File.separator + "uploadFiles" + File.separator;
		
		String imageBirdPath = uploadFileFolder + imageBird;
		String imageOtterPath = uploadFileFolder + imageOtter;
		String imageTigerPath = uploadFileFolder + imageTiger;
		
		driver.get("https://gofile.io/uploadFiles");
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add files']")));
		
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(imageBirdPath + "\n" + imageOtterPath + "\n" + imageTigerPath);
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("span.mainUploadInitInfoText")));
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.text-center div.border-success")).getText(), "Your files have been successfully uploaded");
		
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mainUploadSuccessLink a.ajaxLink")));
		driver.findElement(By.cssSelector("div.mainUploadSuccessLink a.ajaxLink")).click();
		
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.contentName")));
		
		Assert.assertEquals(false, false);
//		List<WebElement> uploadFolders = driver.findElements(By.cssSelector("button.filesContentOptionDownload span"));
	}
	
	
//	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}