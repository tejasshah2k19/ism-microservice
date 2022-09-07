package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;
import com.vo.UserDepartment;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody User user) {
		log.info("UserController :: addUser() ");
		userService.saveUser(user);
		return ResponseEntity.ok(user);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserByIdWithDepartment(@PathVariable("userId") Integer userId) {
		log.info("UserController :: getUserById() ");
		UserDepartment user = userService.findUserByUserId(userId);
		return ResponseEntity.ok(user);
	}
}
