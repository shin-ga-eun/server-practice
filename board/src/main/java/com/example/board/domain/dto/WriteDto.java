package com.example.board.domain.dto;

import java.time.LocalDate;

import com.example.board.domain.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WriteDto {

	private User user;
	private String title;   // 제목
	private String contents;   // 내용
	private LocalDate insertTime;   //작성일
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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
	public LocalDate getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(LocalDate insertTime) {
		this.insertTime = insertTime;
	}

	
}
