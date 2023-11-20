package javaBasic;

public class Topic_01_Data_Type {
	static int studentNumber;
	static boolean studentStatus;
	
	// Final variable is not allow to override
	static final String browserName = "Chrome";
	
	String studentName = "AFC";
	
	
	public static void main(String[] args) {
		System.out.println(studentNumber);
		System.out.println(studentStatus);
	}
	
	
	// Getter
	public String getStudentName() {
		return this.studentName;
	}
	
	// Setter
	public void setStudentName(String stdName) {
		this.studentName = stdName;
	}
}