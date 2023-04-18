package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Handle_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait explicitWait;
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
		/*
		 * ExplicitWait: flexible wait Keep waiting if element not found yet >
		 * over time > failed If found, no need to wait till time out
		 */
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_JQuery() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

		/* First select */
		// 1. Click on arbitrary element and wait all the items to be displayed
		driver.findElement(By.cssSelector("span#speed-button")).click();

		/*
		 * 2. Wait all items loaded successfully Get the tag name presence for
		 * all items Get to the tag name contains the text in dropdown
		 */
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#speed-menu div[role='option']")));

		/*
		 * presence :: visible visible: only elements in visible range presence:
		 * all elements appear in locator
		 */

		// Get all the items in dropdown into a list
		List<WebElement> speedDropdownItems = driver.findElements(By.cssSelector("ul#speed-menu div[role='option']"));

		// 3. Find the needed item ( using "for" loop)
		for (WebElement tempItems : speedDropdownItems) {
			String itemText = tempItems.getText();
			System.out.println(itemText);

			// 4. Check the item correct to the expected
			if (itemText.equals("Fast")) {
				// 5. Click
				tempItems.click();

				// Exit from loop after the condition is satisfied
				break;
			}
		}

		sleepInSecond(3);

		/* Second select */
		// Replace fixed value/parameter with method
		selectItemInDropdown("span#speed-button", "ul#speed-menu div[role='option']", "Faster");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Faster");

		selectItemInDropdown("span#salutation-button", "ul#salutation-menu div[role='option']", "Prof.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(), "Prof.");

		// Code below are not necessary after using the method
		driver.findElement(By.cssSelector("span#speed-button")).click();

		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#speed-menu div[role='option']")));

		speedDropdownItems = driver.findElements(By.cssSelector("ul#speed-menu div[role='option']"));

		for (WebElement tempItems : speedDropdownItems) {
			String itemText = tempItems.getText();
			System.out.println(itemText);

			if (itemText.equals("Faster")) {
				tempItems.click();
				break;
			}
		}
	}

	@Test
	public void TC_02_ReactJS() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

		selectItemInDropdown("i.dropdown.icon", "span.text", "Stevie Feliciano");
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Stevie Feliciano");

		selectItemInDropdown("i.dropdown.icon", "span.text", "Matt");
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Matt");
	}

	@Test
	public void TC_03_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "Second Option");
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");
		
		selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "Third Option");
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Third Option");
		
		selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "First Option");
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "First Option");
	}

	@Test
	public void TC_04_Editable() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		inputAndSelectItemInDropdown("input.search", "span.text", "Angola");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Angola");
		
		inputAndSelectItemInDropdown("input.search", "span.text", "Belgium");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Belgium");
		
		inputAndSelectItemInDropdown("input.search", "span.text", "Austria");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Austria");
	}
	
	public void inputAndSelectItemInDropdown(String textboxCss, String allItemCss, String expectedTextItem) {		
		driver.findElement(By.cssSelector(textboxCss)).click();
		List<WebElement> textboxDropdownItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(allItemCss)));
		for (WebElement tempItem : textboxDropdownItems) {
			if (tempItem.getText().trim().equals(expectedTextItem)) {
				tempItem.click();
				break;
			}
		}
		
	}
	
	public void selectItemInDropdown(String parentCss, String allItemCss, String expectedTextItem) {
		/*
		 * Create a method: 
		 * - To avoid the duplicated of code - Attach with
		 * parameters 
		 * - If transmission a fixed parameter > method is
		 * meaningless 
		 * - To be defined to re-use 
		 * 	++ parentCss allItemCss expectedTextItems are define parameters, will be directly assigned
		 * when using
		 */
		driver.findElement(By.cssSelector(parentCss)).click();
		List<WebElement> speedDropdownItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(allItemCss)));
		for (WebElement tempItem : speedDropdownItems) {
			if (tempItem.getText().trim().equals(expectedTextItem)) {
				tempItem.click();
				break;
				// Trim() > remove the space from leading or trailing text
			}
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