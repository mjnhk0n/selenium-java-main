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
	
	a = b + c;
	
	System.out.println("Cong = " + a);
	
	}
	

}