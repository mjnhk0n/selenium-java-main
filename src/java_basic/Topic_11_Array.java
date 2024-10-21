package java_basic;

import java.util.ArrayList;

public class Topic_11_Array {
	public static void main(String[] agrs) {
		// Fixed element when compile code
		String studentName[] = { "Nam", "Long", "An" };

		for (int i = 0; i < studentName.length; i++) {
			if (studentName[i].equals("Long")) {
				System.out.println("Click vào Long");
			}
		}

		for (String std : studentName) {
			if (std.equals("Long")) {
				System.out.println("Click vào Long");
			}
		}

		// Dynamic
		ArrayList<String> stdName = new ArrayList<String>();

		// Add when running the code (Runtime)
		for (String std : studentName) {
			stdName.add(std);
		}
	}

	public class Student {
		String name;
		int age;

		public Student(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public void display() {
			System.out.println("Name" + name);
			System.out.println("Age" + age);
		}
		
		public static void main(String[] agrs) {
			Student[] students = new Student[3];
			students[0] = new Student(null, 0);
			students[1] = new Student("Long", 24);
			students[2] = new Student("Minh", 24);
			
			for (int i = 0; i < 3; i++) {
				students[i].display();
			}
		}
	}
}
