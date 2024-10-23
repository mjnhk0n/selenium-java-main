package accessMod_1;

public class Animal {
	private String name; // Red icon
	String color; // Blue icon
	protected int eyesNumber; // Yellow icon
	public float weight; // Green icon

	// Modifier:
	// Public & Default: use for class
	// Private & Protected: dont use for class

	// Non-modifier
	// final/static/abstract
	// transient/ volatile/native/synchronize
	public void showName() {
		System.out.println(name);
	}

}
