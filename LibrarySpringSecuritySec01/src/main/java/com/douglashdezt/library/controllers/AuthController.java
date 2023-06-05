package com.douglashdezt.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglashdezt.library.models.dtos.UserLoginDTO;
import com.douglashdezt.library.models.dtos.UserRegisterDTO;
import com.douglashdezt.library.models.entities.User;
import com.douglashdezt.library.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@ModelAttribute @Valid UserLoginDTO info, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User user = userService.findOneByIdentifier(info.getIdentifier());
		
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		if(!userService.comparePassword(info.getPassword(), user.getPassword())) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		//TODO: Crear token
		//TODO: Registrar Token
		//TODO: Devolver token
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@ModelAttribute @Valid UserRegisterDTO info, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User user = userService.findOneByUsernameOrEmail(
				info.getUsername(), 
				info.getEmail());
		
		if(user != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		try {
			userService.register(info);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
