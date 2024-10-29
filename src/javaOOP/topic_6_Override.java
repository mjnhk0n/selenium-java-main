package javaOOP;

public class topic_6_Override {
	// Only use for inheritance class or implements interface
	// Re-define method of parents class
	// Only override the body. Keep the method's name/ return type/ param
	// Override MUST BE NAMED and PARAM VALUE same with parents class
	// Unable to Override:
	// - A final method
	// - Constructor method
	// - Static method
	// - Private method
	// Only able to override a method with the same access modifier or higher
	// than current method
	// Return type MUST BE the same
	class Dog {
		public void bark() {
			System.out.println("woof");
		}
	}

	class Hound extends Dog {
		public void sniff() {
			System.out.println("Sniff sniff");
		}

		public void bark() {
			System.out.println("bowl");
		}
	}

	public class OverridingTest {

		public void main(String[] args) {
			Dog dog = new Hound();
			dog.bark();
		}
	}
}
