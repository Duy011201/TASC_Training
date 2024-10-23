package com.starship.demo.controller;

import com.starship.demo.entity.UserEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private static Map<String, UserEntity> userDatabase = new HashMap<>();

	static {
		userDatabase.put("1", new UserEntity("1", "Alice", 30));
		userDatabase.put("2", new UserEntity("2", "Bob", 25));
		userDatabase.put("3", new UserEntity("3", "Charlie", 35));
	}

	@GetMapping
	public Collection<UserEntity> getAllUsers() {
		return userDatabase.values();
	}

	@GetMapping("/{id}")
	public UserEntity getUserById(@PathVariable String id) {
		return userDatabase.get(id);
	}

	@PostMapping
	public String createUser(@Valid @RequestBody UserEntity user) {
		userDatabase.put(user.getId(), user);
		return "User created: " + user.toString();
	}

	@PutMapping("/{id}")
	public String updateUser(@PathVariable String id,@Valid @RequestBody UserEntity user) {
		userDatabase.put(id, user);
		return "User updated: " + user.toString();
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable String id) {
		userDatabase.remove(id);
		return "User with id " + id + " deleted.";
	}
}
