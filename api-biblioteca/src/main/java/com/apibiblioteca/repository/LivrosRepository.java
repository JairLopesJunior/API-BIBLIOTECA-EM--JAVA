package com.apibiblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apibiblioteca.models.Livros;

@Repository
public interface LivrosRepository extends JpaRepository<Livros, Long> {

	@Query(value = "select * from tb_livros c where usuario_id = ?1", nativeQuery = true)
	List<Livros> findAllById(long id);
}
