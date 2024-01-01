package org.dnyanyog.controller;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@Autowired
	 Loginservice loginService;
	 
	 @PostMapping(
			 path="/auth/validate",
			 consumes= {"application/json","application/xml"},
			 produces= {"application/json","application/xml"})
	 
	 public LoginResponse validate(@RequestBody LoginRequest loginRequest)
	 {
		 return loginService.validateUser(loginRequest);
	 }


}