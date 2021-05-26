package controller;

import model.*;

/**
 * @author Maibritt Bjørn Jacobsen
 * @version 2021-05-28
 */

public class ClientController {

	private Client client;
	
	/*
	 * Constructor
	 */
	public ClientController() {
		
	}
	
	/*
	 * Create an instance of Client
	 */
	public Client createClient(String firstName, String lastName, String phoneNo, String mail) {
		client = new Client(firstName, lastName, phoneNo, mail);
		return client;
				
	}
}
