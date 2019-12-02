package com.example.board.service;

import org.springframework.stereotype.Service;

import com.example.board.domain.dto.WriteDto;
import com.example.board.domain.entity.Board;
import com.example.board.repository.BoardRepository;

@Service
public class BoardService {
	
	//생성자 주입방식
	final BoardRepository boardRepository;
	
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	//create
	public void createUser(WriteDto writedto) {
		// TODO Auto-generated method stub
		Board board = new Board();
		
		board.setUser(writedto.getUser());
			
			
			
		boardRepository.save(board);	
	}
	
	public void updateBoard(Long id) {
		Board board = boardRepository.findById(id).get();
	}



	
	
	
}
