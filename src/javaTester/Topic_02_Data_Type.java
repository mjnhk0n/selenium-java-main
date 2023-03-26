package javaTester;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_02_Data_Type {
	

	public static void main(String[] args) {
		// Kiểu dữ liệu nguyên thủy (Primitive)
		
			// Số nguyên: Byte short Int Long (không có phần thập phân)
				// Kích thước/ độ rộng để lưu dữ liệu từ nhỏ > lớn
				byte 	bNumber=127;
				short 	sNumber=32000;
				int 	iNumber=499999;
				long 	lNumber=999999000;

			// Số thực: float double (có phần thập phân)
				float 	studentPoint=9.5f;
				double 	employeeSalary=35.6d;
				
			// Logic: boolean (true false)
				boolean 
						status=true; // Nam
						status=false; // Nữ
				
			// Ký tự: char
				char 	a='A';
				
		// Kiểu dữ liệu tham chiếu (Reference)
			// Class
			FirefoxDriver driver= new FirefoxDriver();
			
			// Interface
			WebElement firstNameTextbox;
			
			// String
			String firstName = "Automation Testing";
			
			// Object
			Object People;
			
			// Array
			String[] studentName = {"Nguyen Van A", "Hoang Thi B"};
			
			// Collection: List/ Set/ Queue
			List<WebElement> checkboxes = driver.findElement(By.cssSelector(""));
			
			// Map
			Map<String , Interger> student = new HashMap<String, Interger>;
			
			
			
	}

}
