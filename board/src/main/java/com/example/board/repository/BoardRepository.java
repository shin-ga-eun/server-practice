package com.example.board.repository;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.domain.entity.Board;
import com.example.board.domain.entity.User;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	List<Board> findByUserIdentity(String identity);
	

}
