package java_basic;

import org.testng.annotations.Test;

public class Topic_12_String_exercise {
	String courseName = "Automation Testing Advanced 2 3 6 4";
	
	@Test
	public void TC_01() {
		char courseNameArray[] = courseName.toCharArray();
		int countUpper = 0;
		int countLower = 0;
		int countNumber = 0;
		
		for (char letter : courseNameArray) {
			// Uppercase
			if (letter <= 'Z' && letter >= 'A') {
				countUpper++;
			}
			
			// Lowercase
			if (letter <= 'z' && letter >= 'a') {
				countLower++;
			}
			
			// Number
			if (letter <= '9' && letter >= '0') {
				countNumber++;
			}
		}
		System.out.println("Sum of uppercase = " + countUpper);
		System.out.println("Sum of uppercase = " + countLower);
		System.out.println("Sum of uppercase = " + countNumber);
		
	}
	
	
	
	
}
