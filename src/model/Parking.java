package model;

import java.time.LocalDate;

/**
 * @author Maibritt Bjørn Jacobsen
 * @version 2021-05-28
 */

public class Parking {
	
	private Car car;
	private Client client;
	private int location;
	private LocalDate returnDate;
	private LocalDate departureDate;
	private Service service;
	private ServiceType serviceType;
	
	/*
	 * Constructor for the Parking object
	 */
	public Parking() {
		
		car = null;
		client = null;
		location = 0;
		returnDate = null;
		departureDate = null;
		service = null;
		serviceType = null;
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
	public int getLocation() {
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

	/**
	 * @param car adding the car information
	 */
	public void addCarInformation(Car car) {
		this.car = car;
	}

	/**
	 * @param client the client to set
	 */
	public void addClientInformation(Client client) {
		this.client = client;
	}

	/**
	 * @param location2 moving car to a new location
	 */
	public void setLocation(int location) {
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

	/*
	 * @param carMake determines which service
	 */
	public void setService(String carMake) {
		serviceType = ServiceType.CHARGER;
		if (carMake.equalsIgnoreCase("Tesla")) {
			service = Service.TESLA;
		} else {
			service = Service.EON;
		}
	}
	
	/*
	 * Setting the service back to null
	 */
	public void setService() {
		serviceType = null;
		service = null;
	}

	/*
	 * Returns the ServiceType
	 */
	public ServiceType getServiceType() {
		return serviceType;
	}

	/*
	 * Returns the Service
	 */
	public Service getService() {
		return service;
	}

}
