package model;

public class Client {
	
	private String firstName;
	private String lastName;
	private String phoneNo;
	private String mail;
	
	public Client(String firstName, String lastName, String phoneNo, String mail) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.mail = mail;
	}

	/**
	 * @return the clients first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the clients last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the clients phone number
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @return the clients email address
	 */
	public String getMail() {
		return mail;
	}

//	/**
//	 * @param firstName the firstName to set
//	 */
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	/**
//	 * @param lastName the lastName to set
//	 */
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	/**
//	 * @param phoneNo the phoneNo to set
//	 */
//	public void setPhoneNo(String phoneNo) {
//		this.phoneNo = phoneNo;
//	}
//
//	/**
//	 * @param mail the mail to set
//	 */
//	public void setMail(String mail) {
//		this.mail = mail;
//	}

}
