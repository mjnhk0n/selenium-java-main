package tiki.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Shop_Owner_Manage_Cart {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeTest(alwaysRun = true)
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test(groups = {"admin", "Cart"})
	public void Cart_Create() {

	}

	@Test(groups = {"admin", "Cart"})
	public void Cart_View() {

	}

	@Test(groups = {"admin", "Cart"})
	public void Cart_Update() {

	}

	@Test(groups = {"admin", "Cart"})
	public void Cart_Delete() {

	}
}
