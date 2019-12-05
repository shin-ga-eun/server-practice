package com.example.re_board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.re_board.domain.dto.BoardDeleteDto;
import com.example.re_board.domain.dto.BoardSaveDto;
import com.example.re_board.domain.dto.BoardUpdateDto;
import com.example.re_board.domain.dto.GetBoardDto;
import com.example.re_board.service.BoardService;

@RestController
public class BoardController {
	
	final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
	public void saveBoard (@RequestBody BoardSaveDto boardSaveDto) {
		boardService.saveBoard(boardSaveDto);
	}
	
	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public void updateBoard (@RequestBody BoardUpdateDto boardUpdateDto) {
		boardService.updateBoard(boardUpdateDto);
	}
	
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.POST)
	public void deleteBoard (@RequestBody BoardDeleteDto boardDeleteDto) {
		boardService.deleteBoard(boardDeleteDto);
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public List<GetBoardDto> getAllBoard () {
		return boardService.getAllBoard();
	}
	
	@RequestMapping(value = "/board/{id}", method = RequestMethod.GET)
	public GetBoardDto getBoardById (@PathVariable Long id) {
		return boardService.getBoardById(id);
	}
	
	@RequestMapping(value = "/userBoard/{identity}", method = RequestMethod.GET)
	public List<GetBoardDto> getBoardByUserIdentity (@PathVariable String identity) {
		return boardService.getBoardByUserIdentity(identity);
	}
}
