package com.example.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.domain.dto.BoardDeleteDto;
import com.example.board.domain.dto.BoardUpdateDto;
import com.example.board.domain.dto.GetBoardDto;
import com.example.board.domain.dto.WriteDto;
import com.example.board.domain.entity.Board;
import com.example.board.service.BoardService;

@RestController
public class BoardController {

	final private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//board생성
	@RequestMapping(value="/boardcreate",method=RequestMethod.POST)
	public void createBoard (@RequestBody WriteDto writedto) {
		boardService.createBoard(writedto);
	}
	
	//board수정
	@RequestMapping(value="/boardupdate",method=RequestMethod.POST)
	public void updateBoard (@RequestBody BoardUpdateDto boardupdatedto) {
		boardService.updateBoard(boardupdatedto);
	}

	//board삭제
	@RequestMapping(value="/boarddelete",method=RequestMethod.POST)
	public void deleteBoard (@RequestBody BoardDeleteDto boarddeletedto) {
		boardService.deleteBoard(boarddeletedto);
	}

	
	//boardId로 게시물 조회
	@RequestMapping(value="/boardread/{id}",method=RequestMethod.GET)
	public GetBoardDto getBoardById (@PathVariable Long id) {
		return boardService.getBoardById(id);
	}
	
	//게시물 전체 조회
	@RequestMapping(value="/boardread",method=RequestMethod.POST)
	public List<GetBoardDto> getBoardAll () {
		return boardService.getAllBoard();
	}
	
	//작성자 게시물 전체 조회
	@RequestMapping(value="/userboardread/{identity}",method=RequestMethod.GET)
	public List<GetBoardDto> getBoardByUserIdentity (@PathVariable String identity) {
		return boardService.getBoardByUserIdentity(identity);
	}
	
}
