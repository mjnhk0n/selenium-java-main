package java_basic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_09_While_DoWhile {
	WebDriver driver;
	static Scanner scanner = new Scanner(System.in);

	// While: Check the condition first, then run the Body
	// Do-While: Run the body at least 1 time before check the condition
	@Test
	public static void TC_01_While() {
		int number = scanner.nextInt();
		while (number < 100) {
			if (number % 2 == 0) {
				System.out.println(number);
				number++;
			}
		}
	}

	@Test
	public static void TC_02_Do_While() {
		int number = scanner.nextInt();

		do {
			if (number % 2 == 0) {
				System.out.println(number);
				number++;
			}
		} while (number < 100);
	}
}