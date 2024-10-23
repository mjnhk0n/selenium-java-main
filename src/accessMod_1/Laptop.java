package accessMod_1;

public class Laptop {
	public static void main(String[] agrs) {
		Computer comp = new Computer();
		comp.ssdSize = 500;

		System.out.println(comp.ssdSize);

		comp.setSsdSize(600);
		System.out.println(comp.ssdSize);
	}
}
