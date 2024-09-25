package java_basic;

public class Topic_10_Getter_Setter {
	private String carName;
	private String careMachine;
	private String carColor;
	private String carType;
	
	// Right click > Source > Generate Getter - Setter
	public String getCarName() {
		return carName;
	}

	/**
	 * @return the careMachine
	 */
	public String getCareMachine() {
		return careMachine;
	}

	/**
	 * @param careMachine the careMachine to set
	 */
	public void setCareMachine(String careMachine) {
		this.careMachine = careMachine;
	}

	/**
	 * @return the carColor
	 */
	public String getCarColor() {
		return carColor;
	}

	/**
	 * @param carColor the carColor to set
	 */
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	/**
	 * @return the carType
	 */
	public String getCarType() {
		return carType;
	}

	/**
	 * @param carType the carType to set
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	public static void main(String[] args) {
		Topic_10_Getter_Setter topic_10 = new Topic_10_Getter_Setter();
		
	}
	
	
}
