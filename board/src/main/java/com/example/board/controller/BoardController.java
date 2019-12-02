package com.example.board.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.domain.dto.WriteDto;
import com.example.board.service.BoardService;

@RestController
public class BoardController {

	final private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value="/boardcreate",method=RequestMethod.POST)
	public void createBoard (@RequestBody WriteDto writedto) {
		boardService.createBoard(writedto);
	}
}
