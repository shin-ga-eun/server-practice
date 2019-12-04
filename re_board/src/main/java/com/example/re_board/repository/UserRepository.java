package com.example.re_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.re_board.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByIdentity(String identity);
	

}
