package accessMod_1;

import org.openqa.selenium.WebDriver;

public class Dog {
	Animal animal = new Animal(); // instance/ object/ Biến
	WebDriver driver;
	Cat cat = new Cat(); // Can be access if 2 classes in the same package

	public void showProperty() {
		System.out.println();
	}

}
