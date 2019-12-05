package com.example.re_board.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.re_board.domain.dto.BoardDeleteDto;
import com.example.re_board.domain.dto.BoardSaveDto;
import com.example.re_board.domain.dto.BoardUpdateDto;
import com.example.re_board.domain.dto.GetBoardDto;
import com.example.re_board.domain.entity.Board;
import com.example.re_board.domain.entity.User;
import com.example.re_board.repository.BoardRepository;
import com.example.re_board.repository.UserRepository;

@Service
public class BoardService {
	
	@Autowired
	private UserRepository userRepository;

	final BoardRepository boardRepository;
	
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	public void saveBoard (BoardSaveDto boardSaveDto) {
		Board board = new Board();
		User user = userRepository.findByIdentity(boardSaveDto.getIdentity());
		LocalDate insertTime = LocalDate.now();
		
		board.setTitle(boardSaveDto.getTitle());
		board.setContents(boardSaveDto.getContents());
		board.setUser(user);
		board.setInsertTime(insertTime);
		
		boardRepository.save(board);
	}
	
	public void updateBoard (BoardUpdateDto boardUpdateDto) {
		Board board = boardRepository.findById(boardUpdateDto.getId()).get();
		
		if( board.getUser().getIdentity().equals(boardUpdateDto.getIdentity())){
			
			board.setTitle(boardUpdateDto.getTitle());
			board.setContents(boardUpdateDto.getContents());
			
			boardRepository.save(board);
		}
		
	}
	
	public void deleteBoard (BoardDeleteDto boardDeleteDto) {
		Board board = boardRepository.findById(boardDeleteDto.getId()).get();
		
		if( board.getUser().getIdentity().equals(boardDeleteDto.getIdentity())){
			
			boardRepository.delete(board);
		}
		
	}
	
	//read 전체 Board 리스트
	public List<GetBoardDto> getAllBoard () {
		List<Board> boardList = boardRepository.findAll();
		List<GetBoardDto> getBoardList = new ArrayList<>();

		for(int i=0; i<boardList.size(); i++) {
			GetBoardDto getBoard = new GetBoardDto();
			
			getBoard.setTitle(boardList.get(i).getTitle());
			getBoard.setContents(boardList.get(i).getContents());
			getBoard.setIdentity(boardList.get(i).getUser().getIdentity());
			getBoard.setInsertTime(boardList.get(i).getInsertTime());
			
			getBoardList.add(getBoard);
		}
		
		return getBoardList;
	}
	
	//read Board 상세보기
	public GetBoardDto getBoardById (Long id) {
		Board board = boardRepository.findById(id).get();
		GetBoardDto getBoard = new GetBoardDto();
		
		getBoard.setTitle(board.getTitle());
		getBoard.setContents(board.getContents());
		getBoard.setInsertTime(board.getInsertTime());
		getBoard.setIdentity(board.getUser().getIdentity());
		
		return getBoard;	
		
	}
	
	//read 작성자별 Board 리스트
	public List<GetBoardDto> getBoardByUserIdentity (String identity){
		List<Board> boardList = boardRepository.findByUserIdentity(identity);
		List<GetBoardDto> getBoardList = new ArrayList<>();
		
		for(int i=0; i<boardList.size(); i++) {
			GetBoardDto getBoard = new GetBoardDto();
			
			getBoard.setTitle(boardList.get(i).getTitle());
			getBoard.setContents(boardList.get(i).getContents());
			getBoard.setIdentity(boardList.get(i).getUser().getIdentity());
			getBoard.setInsertTime(boardList.get(i).getInsertTime());
			
			getBoardList.add(getBoard);
		}
		
		return getBoardList;	
		
	}
	
}
