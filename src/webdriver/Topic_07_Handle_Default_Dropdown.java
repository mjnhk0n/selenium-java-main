package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Service.State;

public class Topic_07_Handle_Default_Dropdown {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, password, emailAddress, companyName, day, month,
			year;
	String provinceName, cityName, addressName, postalCode, phoneNumber, countryName;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver",
					projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver",
					projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		firstName = "Drink";
		lastName = "Water";
		password = "123456";
		emailAddress = "automation_test" + getRandomNumber() + "@gmail.com";
		companyName = "ABC";
		day = "18";
		month = "October";
		year = "1988";
		countryName = "United States";
		provinceName = "Florida";
		cityName = "Miami";
		addressName = "123sss";
		postalCode = "33111";
		phoneNumber = "+13055555584";
	}

	@Test
	public void TC_01_Register_New_Accoutn() {
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fregister");

		// Click Register at Header
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);

		// Must create new select at this point because the URL contains the
		// element is opening
		// select = new Select(driver.findElement(By.name("DateOfBirthDay")));

		// Select index 17
		// select.selectByIndex(17);
		//
		// Select value (string)
		// select.selectByValue("14");

		/*
		 * Index: Can't not be used if the items inside dropdown is updated
		 * (add/ change/ delete/...) In case the test case fail, can't remember
		 * the index to manual test > wasted time
		 */

		/*
		 * Value: Is not a mandatory element Unable to remember which value is
		 * using for the data
		 */

		/*
		 * Text Can be used if the item inside the dropdown is updated Ez to
		 * manual test the value 
		 * Must have the text for user to select
		 */

		// Select by text
		new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText(day);
		new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);
		new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Company")).sendKeys(companyName);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
		driver.findElement(By.id("register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");

		driver.findElement(By.cssSelector("a.ico-login")).click();

		// Verify information
		driver.findElement(By.name("Email")).sendKeys(emailAddress);
		driver.findElement(By.name("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("button[class='button-1 login-button']")).click();
		driver.findElement(By.cssSelector("a.ico-account")).click();

		Assert.assertEquals(driver.findElement(By.name("FirstName")).getAttribute("value"),firstName);
		Assert.assertEquals(driver.findElement(By.name("LastName")).getAttribute("value"),lastName);
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(),day);
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(),month);
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(),year);
		Assert.assertEquals(driver.findElement(By.name("Email")).getAttribute("value"),emailAddress);
		Assert.assertEquals(driver.findElement(By.name("Company")).getAttribute("value"),companyName);

	}

	@Test
	public void TC_02_Add_Addresses() {
		// Add new address
		driver.findElement(By.cssSelector("li.customer-addresses>a")).click();
		driver.findElement(By.cssSelector("button.add-address-button")).click();
		driver.findElement(By.name("Address.FirstName")).sendKeys(firstName);
		driver.findElement(By.name("Address.LastName")).sendKeys(lastName);
		driver.findElement(By.name("Address.Email")).sendKeys(emailAddress);
		driver.findElement(By.name("Address.Company")).sendKeys(companyName);
		new Select(driver.findElement(By.name("Address.CountryId"))).selectByVisibleText(countryName);
		new Select(driver.findElement(By.name("Address.StateProvinceId"))).selectByVisibleText(provinceName);
		driver.findElement(By.name("Address.City")).sendKeys(cityName);
		driver.findElement(By.name("Address.Address1")).sendKeys(addressName);
		driver.findElement(By.name("Address.ZipPostalCode")).sendKeys(postalCode);
		driver.findElement(By.name("Address.PhoneNumber")).sendKeys(phoneNumber);
		driver.findElement(By.cssSelector("button.save-address-button")).click();
		
		
		// Verify added information
		Assert.assertEquals(driver.findElement(By.cssSelector("li.name")).getText(), firstName + " " + lastName);
		Assert.assertTrue(driver.findElement(By.cssSelector("li.email")).getText().contains(emailAddress));
		Assert.assertTrue(driver.findElement(By.cssSelector("li.phone")).getText().contains(phoneNumber));
		Assert.assertEquals(driver.findElement(By.cssSelector("li.company")).getText(), companyName);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.address1")).getText(), addressName);
		Assert.assertTrue(driver.findElement(By.cssSelector("li.city-state-zip")).getText().contains(cityName));
		Assert.assertTrue(driver.findElement(By.cssSelector("li.city-state-zip")).getText().contains(provinceName));
		Assert.assertTrue(driver.findElement(By.cssSelector("li.city-state-zip")).getText().contains(postalCode));
		Assert.assertEquals(driver.findElement(By.cssSelector("li.country")).getText(), countryName);
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}