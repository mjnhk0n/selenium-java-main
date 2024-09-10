package java_basic;

public class Topic_05_Primitive_Casting {
	public static void main(String[] args) {
		// Implicit - does not lose the data - widening from lower data size to higher
		// Explicit (Cast) - will lose data in some cases - narrowing from higher data size to lower
		
		double dNumber = 654321789651d;
		System.out.println(dNumber);
		
		float fNumber = (float) dNumber;
		System.out.println(fNumber);
		
		long lNumber = (long) dNumber;
		System.out.println(lNumber);
	}
}
