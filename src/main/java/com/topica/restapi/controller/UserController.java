package com.topica.restapi.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.topica.restapi.model.User;
import com.topica.restapi.service.UserService;
import com.topica.restapi.service.UserServiceUpdate;

@RestController
public class UserController {

	@Autowired
	private UserService userRepository;

	@Autowired
	private UserServiceUpdate userServiceUpdate;

	@RequestMapping(path = "/api/getuserid", method = RequestMethod.GET)
	public User getUserById(@RequestParam String id) {
		return userServiceUpdate.getUserId(Integer.parseInt(id));
	}
	
	@RequestMapping(path = "/api/getalluser", method = RequestMethod.GET)
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@RequestMapping(path = "/api/getuserbyrole", method = RequestMethod.GET)
	public List<User> getUserByRole(@RequestParam String role) {
		return userRepository.findUserByRole(Integer.parseInt(role));
	}

	@RequestMapping(path = "/api/adduser", method = RequestMethod.GET)
	@Transactional
	public List<User> addUser(@RequestParam String name, @RequestParam String role) {
		userRepository.save(new User(name, Integer.parseInt(role)));
		return getAllUser();
	}

	@RequestMapping(path = "/api/updateuser", method = RequestMethod.GET)
	public User updateUser(@RequestParam String id, @RequestParam String newname) {
		userServiceUpdate.updateUser(Integer.parseInt(id), newname);
		return getUserById(id);
	}

	@RequestMapping(path = "/api/deleteuser", method = RequestMethod.GET)
	@Transactional
	public List<User> deleteUser(@RequestParam String id) {
		userRepository.deleteUserById(Integer.parseInt(id));
		return getAllUser();
	}

}
