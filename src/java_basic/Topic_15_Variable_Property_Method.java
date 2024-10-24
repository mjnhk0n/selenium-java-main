package java_basic;

public class Topic_15_Variable_Property_Method {
	/*
	 * Property: combine with Getter/ Setter. Use for object like: person, computer,
	 * car,...
	 */
	private String studentName = "Automation FC"; // Global variable

	// Static variable
	public static String studentAddress = "HCMC"; // able to use and assign/ override new data

	private static String studentPhone = "0123456789"; // only able to use inside class contains it

	// Final variable
	final String country = "Viet Nam"; // unable to assign new data

	// Static final variable
	static final float PI_NUMBER = 3.141256f; // able to use but unable to assign/ override new data

	// Variable: can be assign data directly, no need to combine with getter/ setter
	// Variable data type: int/ double/ String/ Object/...
	/*
	 * Class's variable can be: - instance: any class - local - constant ( static)
	 */

	// default
	int StudentID = 100056;

	public static void main(String[] args) {
		// Local variable: Method
		String studentName = "Automation FC";

		if (studentName.startsWith("Automation")) {
			// Local variable: block code
			int number = 100;
		}
	}

	// Constructor
	public Topic_15_Variable_Property_Method() {
		// Local variable: constructor
		String studentName = "Automation FC";

		if (studentName.startsWith("Automation FC")) {
			int number = 100;
		}
	}

	/*
	 * Method Access modifier: public/ private/ ... Return type: - Action: void -
	 * Get: data type Method name: Camel case Parameter list Method body Exception
	 * list (optional)
	 */

	// Static method dont need object to access (directly access from class)
	// In a same class
	// Static method can call to other static method/ property, unable to call
	// non-static method/ property
	// Create an object to access non-static method

}
