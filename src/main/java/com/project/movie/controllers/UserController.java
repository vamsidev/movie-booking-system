package com.project.movie.controllers;

import com.project.movie.entities.User;
import com.project.movie.services.MongoTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.movie.request.UserRequest;
import com.project.movie.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private MongoTemplateService mongoTemplateService;

	@PostMapping("/addNew")
	public ResponseEntity<String> addNewUser(@RequestBody UserRequest userEntryDto) {
		try {
			String result = userService.addUser(userEntryDto);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/domain/{domain}")
	public ResponseEntity<List<User>> findUsersByEmailDomainWithAggregation(@PathVariable String domain){
		List<User> users = mongoTemplateService.findUsersByEmailDomainWithAggregation(domain);
		return ResponseEntity.ok(users);
	}
}
