package controller;

import model.*;

public class ClientController {

	private Client client;
	
	public ClientController() {
		
	}
	
	public Client createClient(String firstName, String lastName, String phoneNo, String mail) {
		client = new Client(firstName, lastName, phoneNo, mail);
		return client;
				
	}
}
