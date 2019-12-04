package com.example.board.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardUpdateDto {

		private Long id; //게시판 넘버
	    private String title;   // 제목
	    private String contents;   // 내용
	    private String identity;   // 작성자 -> 이걸로 findBy해서 사용할 예정
	   
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
		public String getIdentity() {
			return identity;
		}
		public void setIdentity(String identity) {
			this.identity = identity;
		}
	   
	   
	   
}
