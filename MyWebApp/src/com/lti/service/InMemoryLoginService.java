package com.lti.service;

import java.util.HashMap;

public class InMemoryLoginService {

	private HashMap<String, String> users = new HashMap<String, String>();
	
	public InMemoryLoginService() {
		users.put("majrul", "123");
		users.put("dinesh", "456");
		users.put("soumya", "789");		
	}
	
	public boolean authenticate(String uname, String pwd) {
		if(users.containsKey(uname))
			if(users.get(uname).equals(pwd))
				return true;
		return false;
		/*if(uname.equals("majrul") && pwd.equals("123"))
			return true;
		else
			return false;*/
	}

}
