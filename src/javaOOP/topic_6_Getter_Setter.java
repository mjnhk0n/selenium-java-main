package javaOOP;

public class topic_6_Getter_Setter {
	// Getter - Setter use to read or assign value of a private variable
	// Use to control the access of outer class to importance data
	private long amount;
	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			// if Name variable is not init (null) or empty value
			// this name = Unknown
			this.name = "Unknown";
		}
		this.name = name;
	}

	public String getAge() {
		if (Integer.valueOf(age) != -1) {
			// Valid age
			return age;
		} else {
			return "Invalid age";
		}

	}

	public void setAge(int age) {
		if (age > 18) {
			// Check if age is valid or not
			this.age = String.valueOf(age);
		} else {
			this.age = String.valueOf(-1);
		}
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount must be higher than 0");
		}
		this.amount = amount;
	}
}
