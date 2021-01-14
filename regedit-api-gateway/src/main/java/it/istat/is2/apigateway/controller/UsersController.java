package it.istat.is2.apigateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import it.istat.is2.apigateway.dto.UsersDto;
import it.istat.is2.apigateway.service.UserService;

@Controller
@RequestMapping("/api")
public class UsersController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<UsersDto>> getAllUsers() {

		return ResponseEntity.ok(userService.findAllUsers());

	}
	@GetMapping(value = "/users/{id}")
	public UsersDto getUser(@PathVariable("id") Integer id) {

		return userService.findUserById(id);

	}
}
