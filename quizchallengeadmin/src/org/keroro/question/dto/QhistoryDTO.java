package org.keroro.question.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QhistoryDTO {
/*
      <th scope="col">HNO</th>
      <th scope="col">QNO</th>
      <th scope="col">MID</th>
      
      <th scope="col">QUIZ</th>
      <th scope="col">ANSWER</th>
      <th scope="col">MEMBER ANSWER</th>
      <th scope="col">CHECK ANSWER</th>
    
      <th scope="col">REG DATE</th>
      <th scope="col">UPDATE DATE</th>
 */
	Long hno, qno;
	String mid;
	String quiz, answer, memberAnswer, checkAnswer;
	Date regDate, updateDate;
}
