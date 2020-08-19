package com.apibiblioteca.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		Usuarios usuario = ur.findById(id);
		if(usuario != null) {
			l.setUsuarios(usuario);
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
}
