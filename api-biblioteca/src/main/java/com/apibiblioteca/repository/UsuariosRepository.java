package com.apibiblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apibiblioteca.models.Livros;
import com.apibiblioteca.models.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

//	@Query(value = "select * from tb_users c where nome = ?1", nativeQuery = true)
//	CadastroUsuario findByName(String nomeInformado);
	Usuarios findById(long id);
}
