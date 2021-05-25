package com.example.login.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.login.dto.UserDTO;
import com.example.login.models.UserEntity;
import com.example.login.serviceimpl.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	@PostMapping(value="/save")
	public void save(@RequestBody UserDTO user) {
		userService.save(user);
	}
	 @RequestMapping(value = "/user/", method = RequestMethod.GET)
	    public ResponseEntity<List<UserEntity>> listAllUsers() {
	        List<UserEntity> users = userService.findAllUsers();
	        if(users.isEmpty()){
	            return new ResponseEntity<List<UserEntity>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<UserEntity>>(users, HttpStatus.OK);
	    }
	  
	    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	    public ResponseEntity<UserEntity> getUser(@PathVariable("id") long id) {
	        System.out.println("Fetching User with id " + id);
	        UserEntity user = userService.findById(id);
	        if (user == null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	    }
	  
	    @RequestMapping(value = "/user/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody UserDTO user, UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating User " + user.getUsername());
	  
	        if (userService.isUserExist(user)) {
	            System.out.println("A User with name " + user.getUsername() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	  
	        userService.save(user);
	  
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
}
