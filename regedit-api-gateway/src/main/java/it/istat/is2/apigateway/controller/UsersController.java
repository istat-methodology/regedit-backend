package it.istat.is2.apigateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.istat.is2.apigateway.dto.UsersDto;
import it.istat.is2.apigateway.service.UserService;

@Controller
@RequestMapping("/api")
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping("/user/users")
	@ResponseBody
	public List<UsersDto> getAllUsers() {
		return userService.findAllUsers();
	}

	@GetMapping(value = "/user/users/{id}")
	@ResponseBody
	public UsersDto getUser(@PathVariable("id") Integer id) {

		return userService.findUserById(id);

	}
}
