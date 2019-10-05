package com.in28minutes;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validateUser(String user, String password) {
		if(user.equals("in28Minutes") && password.equals("dummy")) {
			return true;
		}
		return false ;
	}

}