package org.keroro.member.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDTO {
	private int difficulty;
	private int correct;
	private int wrong;
	private int total;
	private int totalScore;
	private double avg;
}
