package java_basic;

public class Topic_12_String {
	public static void main(String[] agrs) {
		String s1 = "Cat";
		String s2 = s1;
		String s3 = new String("Cat");
		
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s2 == s3);
		System.out.println(s2.equals(s3));
	}
}
