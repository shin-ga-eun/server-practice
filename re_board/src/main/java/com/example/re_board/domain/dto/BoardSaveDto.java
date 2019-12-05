package com.example.re_board.domain.dto;

import java.time.LocalDate;

public class BoardSaveDto {
	
	private String title;
	private String contents;
	private String identity;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	
	
}
