package java_basic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_04_Operator {
	int number = 10;
	
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
	public static void main(String[] args){
		int number = 10;
		System.out.println(++number);
		System.out.println(number++);
		
		for (int i = 0; i < 3; ++i){
		System.out.println(i);
	}
	
	String address = "Sai Gon";
	
	if (address != "Ha Noi" && address != "Da Nang") {
		System.out.println("Address is different");
		}
	boolean status = (address == "Sai Gon") ? true : false;
		System.out.println(status);
	
	}
}