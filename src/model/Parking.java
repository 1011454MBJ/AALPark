package model;

import java.time.LocalDate;

public class Parking {
	
	private Car car;
	private Client client;
	private String location;
	private LocalDate returnDate;
	private LocalDate departureDate;
	
	public Parking() {
		
		car = null;
		client = null;
		location = null;
		returnDate = null;
		departureDate = null;
	}

	/**
	 * @return the car registered
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @return the client registered
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @return the location car is parked at
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @return the expected date for when car is retrieved
	 */
	public LocalDate getReturnDate() {
		return returnDate;
	}

	/**
	 * @return the expected date of departure
	 */
	public LocalDate getDepartureDate() {
		return departureDate;
	}

//	/**
//	 * @param car the car to set
//	 */
//	public void setCar(Car car) {
//		this.car = car;
//	}
//
//	/**
//	 * @param client the client to set
//	 */
//	public void setClient(Client client) {
//		this.client = client;
//	}

	/**
	 * @param location moving car to a new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @param returnDate updating expected return date
	 */
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * @param departureDate making the departure date future proved
	 */
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	
	

}
