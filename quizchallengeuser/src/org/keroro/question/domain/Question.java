package org.keroro.question.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
	private Long qno;
	private String aid, quiz, answer;
	@Default
	private String deprecated = "n";
	private int difficulty;
	private Date regdate, updatedate;
}
