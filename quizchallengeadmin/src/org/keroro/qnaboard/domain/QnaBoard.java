package org.keroro.qnaboard.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QnaBoard {

	private Long bno,qno;
	private String mid, aid, title, content, status, answer, quiz;
	private int state, category, difficulty;
	private Date regdate, updateDate;
	
	
	public void setBno(Long bno) {
		this.bno = bno;
	}
	public void setQno(Long qno) {
		this.qno = qno;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setStatus(String status) {
		this.status = "0";
	}
	public void setState(int state) {
		if(state > 2) {
			this.state = 0;
		}
		this.state = state;
	}
	public void setCategory(int category) {
		if(category > 4) {
			this.category = 1;
			return;
		}
		this.category = category;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
}
