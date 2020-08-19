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

import com.apibiblioteca.dto.ListarLivrosResponseDTO;
import com.apibiblioteca.dto.SalvarLivrosResponseDTO;
import com.apibiblioteca.models.Livros;
import com.apibiblioteca.models.Usuarios;
import com.apibiblioteca.repository.LivrosRepository;
import com.apibiblioteca.repository.UsuariosRepository;

@RestController
@RequestMapping("/api")
public class LivrosResource {

	@Autowired
	private UsuariosRepository ur;
	
	@Autowired
	private LivrosRepository lr;
	
	@PostMapping("/{id}/livros")
	public ResponseEntity<SalvarLivrosResponseDTO> salvar(@Valid @RequestBody Livros l, @PathVariable("id") long id){
		Usuarios usuarioEncontrado = ur.findById(id);
		if(usuarioEncontrado != null) {
			l.setUsuarios(usuarioEncontrado);
			String titulo = l.getTitulo();
			if(titulo.equals("")) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}else {
				lr.save(l);
				SalvarLivrosResponseDTO response = new SalvarLivrosResponseDTO(true, "Livro cadastrado com sucesso.");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}		
		}else {
			SalvarLivrosResponseDTO response = new SalvarLivrosResponseDTO(false, "Usuário não encontrado.");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}")
	public List<Livros> listar(@PathVariable("id") long id){
		Usuarios usuarioEncontrado = ur.findById(id);
		if(usuarioEncontrado != null) {
			return lr.findAllById(id);
		}else {
			return null;
		}
	}
}
