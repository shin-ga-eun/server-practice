package com.example.board.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.board.domain.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByIdentity (String identity);

}
