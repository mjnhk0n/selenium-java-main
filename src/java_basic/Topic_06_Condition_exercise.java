package java_basic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
public class Topic_06_Condition_exercise {
	WebDriver driver;
	Scanner scanner = new Scanner (System.in);
	
	@Test
	public void TC_01 () {
		int number = scanner.nextInt();
		
		if (number % 2 == 0) {
			System.out.println("Số: " + number + "là số chẵn");
		} else {
			System.out.println("Số: " + number + "là số lẻ");
		}
	}
	
	@Test
	public void TC_02 () {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		
		if (numberA > numberB) {
			System.out.println(numberA > numberB);
		} else if (numberA == numberB) {
			System.out.println(numberA = numberB);
		} else {
			System.out.println(numberA < numberB);
		}
	}
	
	@Test
	public void TC_03 () {
		String firstStudent = scanner.nextLine();
		String secondStudent = scanner.nextLine();
		
		// Reference: String
		// Check the value of variable
		// Check the position of variable in memory
		if (firstStudent.equals(secondStudent)) {
			System.out.println("2 Students have the same name");
		} else {
			System.out.println("2 Students have different name");
		}
		
		// Primitive type
		if (firstStudent == secondStudent) {
			System.out.println("2 Students have the same name");
		} else {
			System.out.println("2 Students have different name");
		}
	}
	
	@Test
	public void TC_04 () {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int numberC = scanner.nextInt();
		
		if (numberA > numberB && numberA > numberC) {
			System.out.println(numberA + "is the highest number");
		} else if (numberB > numberC) {
			System.out.println(numberB + "is the highest number");
		} else {
			System.out.println(numberC + "is the highest number");
		}
	}
	
	@Test
	public void TC_05 () {
		int numberA = scanner.nextInt();
		
		if (10 < numberA && numberA < 100) {
			System.out.println(numberA + "nằm trong khoảng (10 - 100)");
		} else {
			System.out.println(numberA + "không nằm trong khoảng (10 - 100");
		}
	}
	
	@Test
	public void TC_06 () {
		float studentPoint = scanner.nextFloat();
		
		if (studentPoint <=10 && studentPoint >=8.5) {
			System.out.println("A");
		} else if (studentPoint <8.5 && studentPoint >=7.5){
			System.out.println("B");
		} else if (studentPoint <7.5 && studentPoint >=5) {
			System.out.println("C");
		} else if (studentPoint <5 && studentPoint >0) {
			System.out.println("D");
		} else {
			System.out.println("Please re-enter your point");
		}
	}
}
