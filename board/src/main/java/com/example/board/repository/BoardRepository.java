package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.board.domain.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	

}
