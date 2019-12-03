package com.example.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.domain.entity.Board;
import com.example.board.domain.entity.User;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	Board findByUser(User user);
	
	List<Board> findAllByUser(User user);

}
