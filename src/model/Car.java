package model;

public class Car {
	
	private String make;
	private String model;
	private String regNo;
	private String fuelType;
	
	public Car(String regNo, String make, String model, String fuelType) {
		
		this.make = make;
		this.model = model;
		this.regNo = regNo;
		this.fuelType = fuelType;
		
	}

	/**
	 * @return the make of the car
	 */
	public String getMake() {
		return make;
	}
	
	/**
	 * @return the model of the car
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * @return the regNo belonging to the car
	 */
	public String getRegNo() {
		return regNo;
	}
	
	/**
	 * @return the fuelType of the car
	 */
	public String getFuelType() {
		return fuelType;
	}	
	
//	/**
//	 * @param make the make to set
//	 */
//	public void setMake(String make) {
//		this.make = make;
//	}
//
//	/**
//	 * @param model the model to set
//	 */
//	public void setModel(String model) {
//		this.model = model;
//	}	
//
//	/**
//	 * @param regNo the regNo to set
//	 */
//	public void setRegNo(String regNo) {
//		this.regNo = regNo;
//	}
//
//	/**
//	 * @param fuelType the fuelType to set
//	 */
//	public void setFuelType(String fuelType) {
//		this.fuelType = fuelType;
//	}
	
}
