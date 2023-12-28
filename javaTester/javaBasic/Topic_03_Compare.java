package javaBasic;

public class Topic_03_Compare {
	int number = 8;
	
	public static void main(String[] args) {
		// Memory area for X
		int x = 5;
		
		// Memory area for Y
		int y = x;
		
		System.out.println("x = " + x);
		System.out.println("x = " + y);
		
		y = 10;
		
		System.out.println("x = " + x);
		System.out.println("x = " + y);
		
		Topic_03_Compare firstVariable = new Topic_03_Compare();
		Topic_03_Compare secondVariable = firstVariable;
		
		System.out.println("number = " + firstVariable.number);
		System.out.println("number = " + secondVariable.number);
	}
}