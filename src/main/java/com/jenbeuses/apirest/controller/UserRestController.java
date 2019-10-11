package com.jenbeuses.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jenbeuses.apirest.entity.User;
import com.jenbeuses.apirest.service.UserService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("/api")

public class UserRestController {

	@Autowired
	private UserService userService;

	/* http://localhost:8080/api/products */
	@GetMapping("/user")
	public List<User> findAll() {
		return userService.findAll();
	}

	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		userService.save(user);
		return user;
	}

	/**
	 * Login user.
	 *
	 * @param user
	 *            the user
	 * @return the user
	 */
	@PostMapping("/users/login")
	public User loginUser(@RequestBody User user) {
		User ser = null;
		try {
			ser = userService.findUser(user);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ser;
	}

	@PutMapping("/users")
	public User updateProduct(@RequestBody User user) {
		userService.save(user);

		return user;
	}

	@DeleteMapping("/users/{userId}")
	public String deleteProduct(@PathVariable int userId) {
		User product = userService.findById(userId);

		if (product == null) {
			throw new RuntimeException("User id not found -" + userId);
		}

		userService.deleteById(userId);

		return "Deleted product id - " + userId;
	}
}
