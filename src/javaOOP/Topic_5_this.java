package javaOOP;

public class Topic_5_this {
	// Only use in current class
	// Use to refer to current class instance variable (if Global and Local variable
	// have the same name)
	// Can be used to invoke current class method (implicity)/ constructor

	private int firstNumber;
	private int secondNumber;

	// Different variable name
	public void Topic_5_this_diff(int fNumb, int sNumb) {
		firstNumber = fNumb;
		secondNumber = sNumb;
	}

	public void sumNumber_diff() {
		System.out.println(firstNumber + secondNumber);
	}

	public static void main(String[] args) {
		Topic_5_this topic = new Topic_5_this(6, 9);
		topic.sumNumber_diff();
	}

	// Same variable name
	public Topic_5_this(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	public void sumNumber() {
		System.out.println(firstNumber + secondNumber);
	}

	public static void main2(String[] args) {
		Topic_5_this topic = new Topic_5_this(6, 9);
		topic.sumNumber();
	}

	// This must be the first statement in constructor

	// Can be used to return current class instance from the method
	// Builder pattern code
	public class Test {
		public int a;
		public int b;

		// default constructor
		public Test() {
			a = 10;
			b = 20;
		}

		// Method that returns current class instance
		public Test get() {
			return this;
		}

		// Can be passed as an argument in method/ constructor call
		public void display(Test obj) {
			System.out.println("a = " + obj.a);
			System.out.println("b = " + obj.b);
		}

		public void get_2() {
			display(this);
		}
	}

}
