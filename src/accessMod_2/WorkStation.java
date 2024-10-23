package accessMod_2;

import accessMod_1.Computer;

public class WorkStation {
	// abstract class cannot be initialize but can be access by extends
	Computer com = new Computer();
}

public class Laptop extends Computer {

}
