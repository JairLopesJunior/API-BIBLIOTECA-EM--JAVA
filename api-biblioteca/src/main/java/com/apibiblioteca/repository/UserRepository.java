package com.apibiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apibiblioteca.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
