package org.keroro.question.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

	private String mid;
	private int qno;
	private int difficulty;
	private int random;
}
