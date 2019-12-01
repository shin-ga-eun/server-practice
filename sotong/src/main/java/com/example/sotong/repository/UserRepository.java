
package com.example.sotong.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.sotong.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findById(String id);
	
}