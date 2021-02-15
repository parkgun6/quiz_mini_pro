package org.keroro.qnaboard.adminanswer.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminAnswer {

	private Long ano, bno;
	private int status;
	private String answer, aid;
	public void setAno(Long ano) {
		this.ano = ano;
	}
	public void setBno(Long bno) {
		this.bno = bno;
	}
	public void setStatus(int status) {
		if(status > 1) {
			this.status = 0;
			return;
		}
		this.status = status;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	private Date regdate, updateDate;
	
}
