package java_basic;

public class Topic_01_Variable {
	static int studentNumber;
	static boolean studentStatus;
	
	// Final variable is not allow to override
	static final String BROWSER_NAME = "Chrome"; // constant - hằng số, không được thay đổi
	
	String studentName = "AFC";
	
	
	public static void main(String[] args) {
		System.out.println(studentNumber);
		System.out.println(studentStatus);
	}
	
	
	// Getter: getCurrentUrl/ getTitle/...
	public String getStudentName() {
		return this.studentName;
	}
	
	// Setter
	public void setStudentName(String stdName) {
		this.studentName = stdName;
	}
}