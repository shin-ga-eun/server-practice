package com.example.board.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.domain.dto.BoardDeleteDto;
import com.example.board.domain.dto.BoardUpdateDto;
import com.example.board.domain.dto.GetBoardDto;
import com.example.board.domain.dto.WriteDto;
import com.example.board.domain.entity.Board;
import com.example.board.domain.entity.User;
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
		User user = userRepository.findByIdentity(writedto.getIdentity());
				
		board.setTitle(writedto.getTitle());
		board.setContents(writedto.getContents());
		board.setInsertTime(insertTime);
		board.setUser(user);
		
		boardRepository.save(board);
	}
	
	//update
	public void updateBoard(BoardUpdateDto boardUpdateDto) {
		Board board = boardRepository.findById(boardUpdateDto.getId()).get();
		
		if(board.getUser().getIdentity().equals(boardUpdateDto.getIdentity())) {
		
			board.setTitle(boardUpdateDto.getTitle());
			board.setContents(boardUpdateDto.getContents());
			
		}
		
		boardRepository.save(board);
		
	}
		
	//delete
	public void deleteBoard(BoardDeleteDto boardDeleteDto) {
		Board board = boardRepository.findById(boardDeleteDto.getId()).get();
		
		if(board.getUser().getIdentity().equals(boardDeleteDto.getIdentity())){
			
			boardRepository.delete(board);
		}
	}
	
	//read 게시글번호로 게시글하나 조회
	public GetBoardDto getBoardById(Long id) {
		
		Board board = boardRepository.findById(id).get();
		
		GetBoardDto getBoard = new GetBoardDto();
		
		getBoard.setTitle(board.getTitle());
		getBoard.setContents(board.getContents());
		getBoard.setInsertTime(board.getInsertTime());
		getBoard.setIdentity(board.getUser().getIdentity());
		
		return getBoard;
	}
	
	//read 게시글전체 조회
	public List<GetBoardDto> getAllBoard() {
		List<Board> getBoard = boardRepository.findAll();
		List<GetBoardDto> getBoardAll = new ArrayList<>();
		User user;
		GetBoardDto element;
		
		int size = getBoard.size();
		
		for(int i=0; i<size; i++) {
			element = new GetBoardDto();
			user = userRepository.findByIdentity(getBoard.get(i).getUser().getIdentity());
			
			element.setTitle(getBoard.get(i).getTitle());
			element.setContents(getBoard.get(i).getContents());
			element.setInsertTime(getBoard.get(i).getInsertTime());
			element.setIdentity(user.getIdentity());
			
			getBoardAll.add(element);
		}
		
		return getBoardAll;
	}

	//read 작성자 별 게시글 조회
	public List<GetBoardDto> getBoardByUserIdentity (String identity) {
//		User user = userRepository.findByIdentity(identity);
		List<Board> getBoard = boardRepository.findByUserIdentity(identity);		
		List<GetBoardDto> getBoardToUser = new ArrayList<>();
		
		
		int size = getBoard.size();
		
		for(int i=0; i< getBoard.size(); i++) {
			
			GetBoardDto element = new GetBoardDto();
			
			element.setTitle(getBoard.get(i).getTitle());
			element.setContents(getBoard.get(i).getContents());
			element.setInsertTime(getBoard.get(i).getInsertTime());
			element.setIdentity(identity);
			
			getBoardToUser.add(element);
		
		}		
		
		return getBoardToUser;
	}
	
	
	
	
	



	
	
	
}
