package javaOOP;

public class Topic_5_Super {
	// Can be used to refer parents class instance variable
	// Use when there are 2 variables in 2 classes have the same name
	public class Vehicle {
		int maxSpeed = 120;
	}

	public class Car extends Vehicle {
		int maxSpeed = 180;

		void display() {
			System.out.println("Max speed" + super.maxSpeed);
		}
	}

	// Directly call the constructor of parent class
	// Must be placed at first step
	// Automatically call the default no param of parents class if dont use the
	// super
	// Parents class does not define the constructor > no need to use super
}
