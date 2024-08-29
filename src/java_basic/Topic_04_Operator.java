package java_basic;

import org.testng.annotations.Test;

public class Topic_04_Operator {
	
	
	
	@Test 
	public void TC_01 () {
		
	int time = 10;
	String name = "Automation Testing";
	Boolean value = false;
	
	
	
	System.out.println("Time = " + time);
	System.out.println("Name = " + name);
	System.out.println("Value = " + value);
	}
	
	@Test
	public void TC_02() {
		
	int a,b = 10, c = 5;
	
	a = b+c;
	System.out.println("Cong = " + a);
	
	a = b-c;
	System.out.println("Tru = " + a);
	
	a = b*c;
	System.out.println("Nhan = " + a);
	
	a = b/c;
	System.out.println("Chia lay so nguyen = " + a);
	
	a = b%c;
	System.out.println("Chia lay so du = " + a);
	
	b++;
	System.out.println("Tang len 1 = " + b);
	
	b--;
	System.out.println("Giam xuong 1 = " + b);
	
	}
	
	@Test
	public static void TC_03(String[] args){
		int number = 10;
		
		System.out.println(number++);
		// Print number first (10), then increase number by 1 = 11
		
		System.out.println(++number);
		// Increase number by 1 first ( number above = 11 > number = 12), then print
		
	// ++ in prefix and postfix
		int firstVariable = 5, secondVariable = 7;
		int result = firstVariable++ + ++secondVariable - 8;
		
		System.out.println("First variable = " + firstVariable);
		System.out.println("Second variable = " + secondVariable);
		System.out.println("Third variable = " + result);
		
		for (int i = 0; i <= 3, i++);
				System.out.println(i);
	}

}