package com.example.board.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.domain.dto.WriteDto;
import com.example.board.domain.entity.Board;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.UserRepository;

@Service
public class BoardService {
	
	@Autowired
	private UserRepository userRepository;
	
	//생성자 주입방식
	final BoardRepository boardRepository;
	
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	//create
	public void createBoard(WriteDto writedto) {
		// TODO Auto-generated method stub
		Board board = new Board();
		LocalDate insertTime = LocalDate.now();
		
		board.setTitle(writedto.getTitle());
		board.setContents(writedto.getContents());
		board.setInsertTime(insertTime);
		board.setUser(userRepository.findByIdentity(writedto.getIdentity()));
			
		boardRepository.save(board);	
	}
	
//	public void updateBoard(Long id) {
//		Board board = boardRepository.findById(id).get();
//	}



	
	
	
}
