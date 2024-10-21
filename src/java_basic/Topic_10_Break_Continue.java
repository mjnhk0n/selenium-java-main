package java_basic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class Topic_10_Break_Continue {
	WebDriver driver;
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Nested for
		for (int i = 1; i <= 5; i++ ) {
			System.out.println("i = " + i);
			
			
			// Each run of For loop above will apply for all runs of For below
			for (int j = 1; j <= 5; j++) {
				if (j == 4) {
					continue;
				}
				System.out.println("j = " + j);
			}
		}
	}
	
	@Test
	public static void TC_01() {
		String[] month = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
		int i = scanner.nextInt();
		String j = scanner.nextLine();
		
		
		}
}

