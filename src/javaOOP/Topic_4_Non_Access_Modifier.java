package javaOOP;

public class Topic_4_Non_Access_Modifier {
	// Static:
	// - Variable/ Field/ Property
	// - Method
	// Can be directly access in a static method
	// Can be used for all instance/ object
	// Can be override
	static String BROWSER = "Chrome";

	// Non-static
	String serverName = "Testing";

	// Final variable = constant
	// Unable to re-assign
	// Unable to inheritance
	final String carBrand = "Honda";

	public static void main(String[] args) {
		System.out.println(BROWSER);

		BROWSER = "Firefox";
		System.out.println(BROWSER);

		// Must be init an object to use non-static instance
		Topic_4_Non_Access_Modifier topic = new Topic_4_Non_Access_Modifier();
		System.out.println(topic.serverName);

		sendKeyToElement("link"); // can be used directly if it is static method in the same class, no need to
									// init the object
	}

	// Static method
	public static void sendKeyToElement(String elementName) {
		System.out.println(elementName);
	}

	// Final method
	// Unable for other class to override the method
	public final void setCarName() {
	}

	// Do not alert error in compile process ( compiler when coding incorrect
	// convention/ Java standard > error alert)

	// 2 errors type:
	// Compiler: alert when coding
	// Runtime: alert when running system/ test cases

	// Abstract
	// Do not have abstract variable, only Class and Interface
	abstract String animal = "dog";

	abstract class Animal {
	}

	// inherit method MUST override the abstract method
	@Override
	abstract void setAnimalName();
	// Use with public or protected modifier
	// Unable to init if it is an abstract class
	// Only return type/ method/ param - no body

	// Synchronized
	// Method:
	// - Must be access in queue order, no parallel. Use for parallel testing/
	// single ton pattern/ multiple thread

}
