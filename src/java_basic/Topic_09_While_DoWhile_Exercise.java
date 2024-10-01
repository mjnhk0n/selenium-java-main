package java_basic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_09_While_DoWhile_Exercise {
	WebDriver driver;
	static Scanner scanner = new Scanner(System.in);

	// While: Check the condition first, then run the Body
	// Do-While: Run the body at least 1 time before check the condition

	@Test
	public static void TC_01_While() {
		int numA = scanner.nextInt();
		int numB = scanner.nextInt();

		while (numA < numB) {
			if (numA % 3 == 0 && numA % 5 == 0) {
				System.out.println(numA);
			}
			numA++;
		}
	}

	@Test
	public static void TC_02_While() {
		int number = scanner.nextInt();
		int i = 0;

		while (number > 0) {
			if (number % 2 != 0) {
				i += number;
			}
			number--;
		}
		System.out.println(i);
	}

	@Test
	public static void TC_03_While() {
		int numA = scanner.nextInt();
		int i = 1;
		
		while (numA > 0) {
			i *= numA;
			numA--;
		}
		System.out.println(i);
	}
	
	@Test
	public static void TC_04_While() {
		int numA = 0;
		int i = numA;
		
		while (numA <= 10) {
			if (numA % 2 == 0) {
				i += numA;
			}
			numA++;
		}
		System.out.println(i);
	}
}