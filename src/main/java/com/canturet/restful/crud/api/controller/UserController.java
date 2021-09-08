package com.canturet.restful.crud.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canturet.restful.crud.api.entity.User;
import com.canturet.restful.crud.api.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public User addUser(@Valid  @RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping
	public List<User> findAllUsers() {
		return userService.getUsers();
	}

	@GetMapping("/{id}")
	public User findUserById(@PathVariable long id) {
		return userService.getUserById(id);
	}

	@PutMapping
	public User updateUser(@Valid @RequestBody User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable long id) {
		return userService.deleteUser(id);
	}

}
