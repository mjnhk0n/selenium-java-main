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

	public static void main(String[] args) {
		System.out.println(BROWSER);

		BROWSER = "Firefox";
		System.out.println(BROWSER);

		// Must be init an object to use non-static instance
		Topic_4_Non_Access_Modifier topic = new Topic_4_Non_Access_Modifier();
		System.out.println(topic.serverName);
	}

}
