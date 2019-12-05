package com.example.re_board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.re_board.domain.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	List<Board> findByUserIdentity(String identity);

}
