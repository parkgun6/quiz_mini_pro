package org.keroro.question.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Qhistory {
	Long hno, qno;
	String mid, memberAnswer, checkAnswer;
	Date regDate, updateDate;
}
