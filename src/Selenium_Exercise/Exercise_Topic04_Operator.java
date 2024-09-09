package Selenium_Exercise;

import org.testng.annotations.Test;

public class Exercise_Topic04_Operator {
	@Test
	public void swapNumber() {
		int a = 5;
		int b = 6;
		
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println(a);
		System.out.println(b);
				
	}
}
