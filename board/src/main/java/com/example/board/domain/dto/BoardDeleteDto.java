package com.example.board.domain.dto;

public class BoardDeleteDto {
	
	private Long id; //게시물 번호
	private String identity; //작성자

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	
	
	
}