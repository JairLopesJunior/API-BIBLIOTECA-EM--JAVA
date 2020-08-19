package com.apibiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apibiblioteca.models.Livros;

@Repository
public interface LivrosRepository extends JpaRepository<Livros, Long> {

	
}
