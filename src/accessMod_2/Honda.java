package accessMod_2;

import accessMod_1.Car;

public class Hyundai extends Car() {
		// Cannot subclass if the class is final
	}

public class Honda {
	// But can access by initializing
	Car car = new Car();

	}
}
