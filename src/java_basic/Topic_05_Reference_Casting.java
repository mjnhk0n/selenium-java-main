package java_basic;import java.awt.SecondaryLoop;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Topic_05_Reference_Casting {
	
	protected String studentName;
		
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName (String studentName) {
		this.studentName = studentName;
	}
	
	public void showStudentInfor() {
		System.out.println("Student Name = " + studentName);
	}
	public static void main (String[] agrs) {
		Topic_05_Reference_Casting firstStudent = new Topic_05_Reference_Casting();
		Topic_05_Reference_Casting secondStudent = new Topic_05_Reference_Casting();
		
		firstStudent.setStudentName("Student A");
		secondStudent.setStudentName("Student B");
		
		firstStudent.showStudentInfor();
		secondStudent.showStudentInfor();
		
		// Cast
		firstStudent = secondStudent;
		
		firstStudent.showStudentInfor();
		secondStudent.showStudentInfor();
		
		secondStudent.setStudentName("Student C");
		
		firstStudent.showStudentInfor();
		secondStudent.showStudentInfor();
		
		WebDriver driver = null;
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	}
}

