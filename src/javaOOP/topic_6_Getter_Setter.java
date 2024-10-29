package javaOOP;

public class topic_6_Getter_Setter {
	// Getter - Setter use to read or assign value of a private variable
	// Use to control the access of outer class to importance data
	private long amount;

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
