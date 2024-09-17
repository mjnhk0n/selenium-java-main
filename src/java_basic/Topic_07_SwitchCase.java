package java_basic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_07_SwitchCase {
	WebDriver driver;
	String projecPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
	@Test
	public void TC_01 () {
		int month = scanner.nextInt();
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("This month have 31 days");
			break;
		case 2:
			System.out.println("This month have 28 days");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("This monthe have 30 days");
			break;
		default:
			System.out.println("Wrong input");
		}
	}
	
}
