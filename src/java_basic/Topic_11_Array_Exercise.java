package java_basic;

import org.testng.annotations.Test;

public class Topic_11_Array_Exercise {
	int number[] = { 5, 8, 15, 7, 60, 1 };

	@Test
	public void TC_01_Find_Max_Number() {
		int x = 0;
		for (int i = 0; i < number.length; i++) {
			if (x < number[i]) {
				x = number[i];
			}
		}
		System.out.println("Max number =" + x);
	}

	@Test
	public void TC_02_Sum_First_Last_number() {
		System.out.println(number[0] + number[number.length - 1]);
	}

	@Test
	public void TC_03() {
		for (int i = 0; i < number.length; i++) {
			if (i % 2 == 0) {
				System.out.println("Even number =" + i);
			}
		}
	}

	@Test
	public void TC_04() {
		for (int i = 0; i < number.length; i++) {
			if (i > 0 && i <= 10) {
				System.out.println("Number i (0 < i <= 10) =" + i);
			}
		}
	}

	@Test
	public void TC_05() {
		int sum = 0;
		for (int i = 0; i < number.length; i++) {
			sum += number[i];
			sum = sum+ number[i];
		}
	}
}
