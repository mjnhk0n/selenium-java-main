package javaOOP;

public class Topic_5_Super {
	// Can be used to refer parents class instance variable
	// Use when there are 2 variables in 2 classes have the same name
	public class Vehicle {
		int maxSpeed = 120;
	}

	// Must be placed at first step
	// Use to select a specific constructor
	public Topic_5_Super() {
		System.out.println("constructor cha"); // If do not use super > call the constructor without param
	}

	public Topic_5_Super(String name) {
		System.out.println("constructor cha" + name);
	}

	public Topic_5_Super(int number) {
		System.out.println("constructor cha" + number);
	}

	public class Car extends Vehicle {
		int maxSpeed = 180;

		void display() {
			System.out.println("Max speed" + super.maxSpeed);
		}
	}
	// If there is no constructor in parents class > compiler auto create a default
	// constructor
}
