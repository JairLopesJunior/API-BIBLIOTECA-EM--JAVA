package com.apibiblioteca.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apibiblioteca.models.Usuarios;
import com.apibiblioteca.repository.UsuariosRepository;

@RestController
@RequestMapping("/api")
public class UsuariosResource {

	@Autowired
	private UsuariosRepository users;
	
	@PostMapping
	public Usuarios cadastrar(@Valid @RequestBody Usuarios user) {
		return users.save(user);
		
	}
	
	@GetMapping
	public List<Usuarios> listar(){
		return users.findAll();
	}

}
