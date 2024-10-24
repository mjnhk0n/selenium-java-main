package java_basic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_12_String {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		// String is immutable, when a new value is created, the system will create a
		// new string, not replace
		String schoolName = "Automation Testing";
		String schoolAddress = "HCM City";
		String courseName = "AUTOMATION TESTING";

		// length: the character's number of the string
		System.out.println(schoolName.length());

		// charAt: get the character at selected position in the string
		System.out.println(schoolName.charAt(1));

		// concat: merge 2 string
		System.out.println(schoolName.concat(schoolAddress));

		// equals: compare if 2 string is completely equal
		System.out.println(schoolName.equals(schoolAddress));
		System.out.println(schoolName.equals("Automation Testing"));

		// equalsIgnoreCase: compare if 2 string is relative equal
		System.out.println(schoolName.equalsIgnoreCase(courseName));

		// startsWith/ endsWith/ contains
		System.out.println(schoolAddress.startsWith("H"));
		System.out.println(schoolName.endsWith("City"));
		System.out.println(courseName.contains("C"));

		// index: position of the character/ string in the string
		System.out.println(schoolName.indexOf("M"));
		System.out.println(schoolName.indexOf("TOMA"));

		// substring: split character/ string from string
		System.out.println(schoolAddress.substring(5));
		System.out.println(schoolName.substring(3, 7));

		// split: split text to array based on character or string
		String result = "Viewin 48 of 132 results";
		String results[] = result.split(" ");

		System.out.println(results[1]);

		// Replace: replace a character or string
		String productPrice = "$100.00";
		productPrice.replace("$", "");
		System.out.println(productPrice);

		// To sort data
		float productPriceF = Float.parseFloat(productPrice);
		System.out.println(productPriceF);

		productPrice = String.valueOf(productPriceF);
		System.out.println(productPrice);

		String osName = System.getProperty("os.name");
		System.out.println(osName);

		// handle multiple OS: Mac/ Windows

		String driverInstanceName = driver.toString();
		System.out.println(driverInstanceName);

		if (osName.toLowerCase().contains("windows")) {
			Keys key = Keys.CONTROL;
		} else {
			Keys key = Keys.COMMAND;
		}

		// Close browser/ driver
		if (driverInstanceName.contains("internetexplorer")) {
			// Fixed sleep 5s after switch page event
		}

		// Trim: Get rid of blank/ tab at the start or end of the string
		String helloWorld = "	\n \t Hello World 	";

		System.out.println(helloWorld.trim());

		// Dynamic locator
		// %s: represent for a string
		String dynamicButtonXpath = "//button[@id='%s']";
		System.out.println("click login button" + String.format(dynamicButtonXpath, "login"));
		System.out.println("click Search button" + String.format(dynamicButtonXpath, "search"));
		System.out.println("click Register button" + String.format(dynamicButtonXpath, "register"));

	}

}
