package org.keroro.qnaboard.reply.domain;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reply {

	private Long rno, bno;
	private String mid, reply;
	private Date regdate, updateDate;
}
