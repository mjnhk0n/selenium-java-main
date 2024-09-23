package java_basic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_08_For_Foreach {
	WebDriver driver;
	@Test
	public void TC_01_For() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
	// int i: default variable
	// i < 5: compare i to the total
	// i++	: add 1 value to i
	
	// Array
		String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho"};
		
		for (int i = 0; i < cityName.length; i++) {
			System.out.println(cityName[i]);
		}
		
		for (int i = 1; i <= cityName.length; i++) {
			System.out.println(cityName[0]);
			System.out.println(cityName[1]);
			System.out.println(cityName[2]);
			System.out.println(cityName[3]);
		}
		
		// Combine with if
		// Use for filter, stop when met the condition
		for (int i = 0; i < cityName.length; i++) {
			if (cityName[i].equals("Ha Noi")) {
				// action
				System.out.println("action");
				break;
			}
		}
		
		// Scan all the element even the condition is met
		
		for (int i = 0; i < cityName.length; i++) {
			if (cityName[i].equals("Ha Noi")) {
				// action
				System.out.println("action");
			}
		}
	}
		
	@Test
	public void TC_02_For() {
		String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho"};
		
		for (String city : cityName) {
			System.out.println(city);
		}
		
		// Java collection
		// Class: ArrayList/ LinkedList/ Vector ...
		// Interface: List/Set/Queue
		
		List<String> cityAddress = new ArrayList<String>();
		System.out.println(cityAddress.size());
		
		// Compile (Coding)
		cityAddress.add("Bac Giang");
		cityAddress.add("Ha Giang");
		cityAddress.add("Sapa");
		System.out.println(cityAddress.size());
		
		// Runtime (running)
		for (String city : cityName) {
			cityAddress.add(city);
		}
		
		System.out.println(cityAddress.size());
		
		for (String cityAdd : cityAddress) {
			System.out.println(cityAdd);
		}
		
		//Java Generic
		List<WebElement> buttons = driver.findElements(By.xpath(""));
		
		// Xử lí data/ get text / value/ css/ attribute
		for (WebElement button : buttons) {
			// Do not use for click
			// Click > Switch page
			// refresh DOM/HTML
			// No exist > Fail
		}
		
		// For can be use to run in reverse
		// Foreach can NOT be use to run in reverse
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
		}
	}
	
	
}
