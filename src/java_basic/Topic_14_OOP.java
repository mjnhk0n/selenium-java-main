package java_basic;

public class Topic_14_OOP {
	private String studentName;
	private Float theoryPoint;
	private Float practicePoint;
	private Float averagePoint;
	private int studentID;

	/**
	 * @return the studentID
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the theoryPoint
	 */
	public Float getTheoryPoint() {
		return theoryPoint;
	}

	/**
	 * @param theoryPoint the theoryPoint to set
	 */
	public void setTheoryPoint(Float theoryPoint) {
		this.theoryPoint = theoryPoint;
	}

	/**
	 * @return the practicePoint
	 */
	public Float getPracticePoint() {
		return practicePoint;
	}

	/**
	 * @param practicePoint the practicePoint to set
	 */
	public void setPracticePoint(Float practicePoint) {
		this.practicePoint = practicePoint;
	}

	/**
	 * @return the averagePoint
	 */
	public Float getAveragePoint() {
		return (this.theoryPoint + this.practicePoint * 2) / 3;
	}

	private void showStudentInfor() {
		System.out.println("----------------");
		System.out.println("Student ID: " + getStudentID());
		System.out.println("Student Name: " + getStudentName());
		System.out.println("Student theory point: " + getTheoryPoint());
		System.out.println("Student practice point: " + getPracticePoint());
		System.out.println("Student average point: " + getAveragePoint());

	}

	public static void main(String[] args) {
		Topic_14_OOP firstStudent = new Topic_14_OOP();
		firstStudent.setStudentID(00001);
		firstStudent.setStudentName("Minh");
		firstStudent.setTheoryPoint(7.0f);
		firstStudent.setPracticePoint(8.5f);
		firstStudent.showStudentInfor();

		Topic_14_OOP secondStudent = new Topic_14_OOP();
		secondStudent.setStudentID(00002);
		secondStudent.setStudentName("Viet");
		secondStudent.setTheoryPoint(7.5f);
		secondStudent.setPracticePoint(9.5f);
		secondStudent.showStudentInfor();
	}
}
