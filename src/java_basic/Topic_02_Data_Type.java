package java_basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	// Primitive type/ value type ( Kiểu dữ liệu nguyên thủy)
	byte bNumber;
	short sNumber;
	int iNumber;
	long lNumber;
	float fNumber;
	double dNumber;
	char cChar;
	boolean bStatus;
	
	// Non-primitive type/ Reference type
	// String
	String address = "Ha Noi";
	
	// Array
	String[] studentAddress = {"HCM", address, "DN"};
	Integer[] studentNumber = { 3, 20, 50 };
	
	// Class
	Topic_02_Data_Type topic;
	
	// Interface
	WebDriver driver;
	
	// Object
	Object aObject;
	
	// Collection
	// List/ Set/ Queue/ Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	Set<String> allWindows = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();
	
	public void clickToElement() {
		address.trim();
		studentAddress.clone();
		driver.getCurrentUrl();
		aObject.toString();
		homePageLinks.size();
		allWindows.clear();
	}
	
	// Stack: save the variable ( int/ long/ string/...) or primitive type
	// Heap: Save the reference of variable
	
	
	public static void main(String[] args) {
		
	}
}
