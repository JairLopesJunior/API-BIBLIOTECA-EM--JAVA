package com.apibiblioteca.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apibiblioteca.dto.AtualizarUsuariosResponseDTO;
import com.apibiblioteca.dto.RemoverUsuariosResponseDTO;
import com.apibiblioteca.dto.SalvarUsuariosResponseDTO;
import com.apibiblioteca.models.Usuarios;
import com.apibiblioteca.repository.UsuariosRepository;

@RestController
@RequestMapping("/api")
public class UsuariosResource {

	@Autowired
	private UsuariosRepository users;
	
	@PostMapping
	public ResponseEntity<SalvarUsuariosResponseDTO> cadastrar(@Valid @RequestBody Usuarios user) {
		SalvarUsuariosResponseDTO response = new SalvarUsuariosResponseDTO(true, "Usuário cadastrado com sucesso.");
		users.save(user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<RemoverUsuariosResponseDTO> cadastrar(@PathVariable("id") long id) {
		Usuarios u = users.findById(id);
		if(u != null) {
			users.delete(u);
			RemoverUsuariosResponseDTO response = new RemoverUsuariosResponseDTO(true, "Usuário deletado com sucesso.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			RemoverUsuariosResponseDTO response = new RemoverUsuariosResponseDTO(false, "Usuário não encontrado.");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AtualizarUsuariosResponseDTO> atualizarUsuario(@Valid @RequestBody Usuarios usuarioInformado,@PathVariable("id") long id){
		Usuarios usuarioEncontrado = users.findById(id);
		if(usuarioEncontrado != null) {
			users.save(usuarioInformado);
			AtualizarUsuariosResponseDTO response = new AtualizarUsuariosResponseDTO(true, "Usuário atualizado com sucesso.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			AtualizarUsuariosResponseDTO response = new AtualizarUsuariosResponseDTO(false, "Usuário não encontrado.");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping
	public List<Usuarios> listar(){
		return users.findAll();
	}

}
