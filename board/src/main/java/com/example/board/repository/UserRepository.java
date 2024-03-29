package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.board.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByIdentity (String identity);

}
