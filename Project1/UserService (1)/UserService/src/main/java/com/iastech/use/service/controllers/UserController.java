package com.iastech.use.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iastech.use.service.entities.User;
import com.iastech.use.service.payload.UserDto;
import com.iastech.use.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
@Autowired
private UserService userService;

@PostMapping
public ResponseEntity<User> createUser(@RequestBody User user){
	User user2=userService.saveUser(user);
	return ResponseEntity.status(HttpStatus.CREATED).body(user2);
	
}
@GetMapping("/id/{userId}")
public ResponseEntity<UserDto> getUserById(@PathVariable String userId){
	UserDto user=userService.getUserById(userId);
	return ResponseEntity.ok(user);
}
@GetMapping("/name/{userName}")
public ResponseEntity<UserDto> getUserByName(@PathVariable String userName){
	UserDto user=userService.getUserByUserName(userName);
	return ResponseEntity.ok(user);
}
@GetMapping
public ResponseEntity<List<UserDto>> getAllUsers(){
	List<UserDto> allUsers=userService.getAllUsers();
	return ResponseEntity.ok(allUsers);
}

}
