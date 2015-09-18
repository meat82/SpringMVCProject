package com.technia.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class PersonServiceController {

	public PersonServiceController() {
		// TODO Auto-generated constructor stub
	}
	@WebMethod
    public String greeting() {
    	System.out.println("Nakki!");
        return "NAKKI";
    }
}
