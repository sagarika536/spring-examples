package com.automate.task.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automate.task.entities.User;
import com.automate.task.repository.UserRepository;



@RestController
@RequestMapping("/userApi")
public class UserController {

	@Autowired
	UserRepository userRepo;
	@GetMapping("/getAll")
	public List<User> getAllUsers(){
		List<User> users=userRepo.findAll();
		return users;
	}
	
	@GetMapping("/getById/{id}")
	public User getUserById(@PathVariable Long id) {
		Optional<User> userOpt=userRepo.findById(id);
		User user=userOpt.get();
		return user;
	}
	@GetMapping("/getByName/{name}")
	public User getUserById(@PathVariable String name) {
		User user=userRepo.findByName(name);
		return user;
	}
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
	User createdUser=	userRepo.save(user);
		return createdUser;
	}
	@PutMapping("/updateUser")
	public User saveOrUpdateUser(@RequestBody User user) {
	User createdUser=	userRepo.save(user);
		return createdUser;
	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		User user1=userRepo.getOne(id);
		userRepo.delete(user1);
		return "deleted";
	}
}
