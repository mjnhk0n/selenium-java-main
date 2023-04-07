package testNG;

import org.testng.Assert;

public class Topic_01_Assert {

	public static void main(String[] args) {
		// Assert library
		// Expected the result is correct (True)
		Assert.assertTrue(3 < 5);
		
		String fullName = "Automation Testing";
		
		Assert.assertTrue(fullName.contains("Testing"));
		
		// Expected the result is incorrect (false)
		Assert.assertFalse(fullName.contains("Manual"));
		
		// Expected = Actual result (Equals)
		Assert.assertEquals(fullName, "Automation Testing");
		
	}

}
