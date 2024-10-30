package javaOOP;

public class topic_10_Try_Catch {
	// When an exception occur in Try it will be thrown for Catch to handle without
	// end the program
	public static void main(String[] args) {
		try {
			System.out.println("Divide math");
			int result = 10 / 2;
			System.out.println("10 divide by 2 = " + result);

			result = 10 / 4;
			System.out.println("10 divide by 4 = " + result);

			result = 10 / 0;
			System.out.println("10 divide by 0 = " + result);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("There is a division can not be done");
		}
	}
	// Can have only Try without Catch, but if have Catch, it MUST HAVE Try
	// Can have multiple Catch
}
