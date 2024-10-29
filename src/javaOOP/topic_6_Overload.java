package javaOOP;

public class topic_6_Overload {
	// Overload is use only within the class
	// In 1 class can be define same method name but:
	// - Same amount of param but must be different data type
	// - Different amount of param then no need to different data type
	// Overloading will do it best when calling from other class

	public class Car {
		// Constructor with 1 argument
		public Car(String name) {
			System.out.println(name);
		}

		// Constructor with 2 arguments
		public Car(String name, int kilometer) {
			System.out.println(name + "-" + kilometer);
		}

		// Constructor with 1 argument but different type
		public Car(float price) {
			System.out.println(price);
		}

		public static void main(String[] args) {
			Car car = new Car("Honda");

			car = new Car("Honda", 150);

			car = new Car(15000f);
		}
	}
}
