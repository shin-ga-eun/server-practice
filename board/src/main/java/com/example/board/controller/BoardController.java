package com.example.board.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.board.service.BoardService;

@RestController
public class BoardController {

	final private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	
}
