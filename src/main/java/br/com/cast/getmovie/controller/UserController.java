package br.com.cast.getmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.getmovie.dto.UserDTO;
import br.com.cast.getmovie.service.UserService;

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public UserDTO searchById(@PathVariable("id") Integer id){
		UserDTO dto = service.searchById(id);
		return dto;
	}
	
	@RequestMapping(path="/email/{email}/pass/{password}", method=RequestMethod.GET)
	public UserDTO login(@PathVariable("email")String email, 
						 @PathVariable("password")String password){
		UserDTO dto = service.login(email, password);
		return dto;
	}
}
