package javaTester;

import java.util.Random;

public class Topic_05_Random {
	
	
	public static float testCount;

	public static void main(String[] args) 
	{
		// ultilites = tiện ích
		Random rand = new Random();
		rand.int(9999);
	}
	
	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
