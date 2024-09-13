package java_basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@Test
	public void TC_01_if () {
		
	}
	
	@Test
	public void TC_02_if_else () {
		// Have 2 conditions: True > if - False > else
		// If driver start with Chrome/ FF/ Edge / Safari > use click function of TestNG
		// If driver start with IE > use click function of jsExecutor
		System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		if (driver.toString().contains("internet explorer")) {
			System.out.println("Click by jsExecutor");
		} else {
			System.out.println("Click by Selenium WebElement");
		}
	}
	
	@Parameters("broser")
	@Test
	public void TC_03_if_elseif_else(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else { // Safari/ Opera/ Coccoc ...
			throw new RuntimeException("Please input correct browser's name");
		}
		
		// If - else rút gọn = ? :
		int age = 17;
		String access = (age < 18) ? "You can not access" : "Welcome to the system";
		
		if (age < 18) {
			access = "You can not access";
		} else {
			access = "Welcome to the system";
		}
	}
}
	
		
