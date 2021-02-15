package org.keroro.question.dto;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QhistoryDTO {
/*
 history.HNO, history.qno, history.mid, question.quiz, question.ANSWER,
    question.difficulty, history.memberanswer, history.CHECKANSWER, history.REGDATE, history.UPDATEDATE
 */
	private Long qno, hno;
	private String mid, quiz, answer, memberAnswer, checkAnswer;
	private int difficulty;
	private Date regDate, updateDate;
	
}
