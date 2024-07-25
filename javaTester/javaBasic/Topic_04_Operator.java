package javaBasic;

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
	public void TC_03(){
		
	// ++ in prefix and postfix
		int firstVariable = 5, secondVariable = 7;
		int result = firstVariable++ + ++secondVariable - 8;
		
		System.out.println("First variable = " + firstVariable);
		System.out.println("Second variable = " + secondVariable);
		System.out.println("Third variable = " + result);
		
	}

}