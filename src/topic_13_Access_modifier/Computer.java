package topic_13_Access_modifier;

public class Computer {
	// Property
	// Private: able to access only in same class
	private int ssdSize;

	// Default: can access in any class in the same package
	String ramBrand;

	// Protected: able to be access by any class in different class using extends
	protected String cpuBrand;

	// Public: able to be accessed by any class by any method
	public
	// Method
	// Private sample
	private void setSsdSize(int ssdSize) {
		this.ssdSize = ssdSize;
		// this: use when there is 2 instances have a same name/ id
		// this will choose the global instance
	}

	public static void main(String[] agrs) {
		Computer comp = new Computer();
		comp.ssdSize = 500;

		System.out.println(comp.ssdSize);

		comp.setSsdSize(600);
		System.out.println(comp.ssdSize);
	}

	// Default sample:
	void setRamBrand(String ramBrandName) {
		ramBrand = ramBrandName;
	}

	// Protected sample
}
