package com.apibiblioteca.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apibiblioteca.models.User;
import com.apibiblioteca.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserResource {

	@Autowired
	private UserRepository users;
	
	@PostMapping
	public User cadastrar(@Valid @RequestBody User user) {
		return users.save(user);
		
	}
	
	@GetMapping
	public List<User> listar(){
		return users.findAll();
	}

}
