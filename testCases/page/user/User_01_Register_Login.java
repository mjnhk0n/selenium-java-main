package page.user;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_01_Register_Login {
	// Global variant
	String homePageURL = "";
	
	@BeforeClass
	public void beforeClass() {
		
	}
	
	@Test
	public void TC_01() {
		// Local variant: Only be used inside the block code of testcase/ method
		String homePageURL = "";
		
		System.out.println(homePageURL);
	}
	
	public void TC_02() {
		
	}
	
	@AfterClass
	public void afterClass() {
		
	}
}
