package it.istat.mec.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.istat.mec.users.dto.UsersDto;
import it.istat.mec.users.service.UserService;


@Controller
@RequestMapping("/api")
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	@ResponseBody
	public List<UsersDto> getAllUsers(@RequestParam(value = "role",required = false) String role) {
		return userService.findAllUsers(role);
	}

	@GetMapping(value = "/users/{id}")
	@ResponseBody
	public UsersDto getUser(@PathVariable("id") Integer id) {

		return userService.findUserById(id);

	}
}
