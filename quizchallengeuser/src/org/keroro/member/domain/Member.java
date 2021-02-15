package org.keroro.member.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private String mid, mpw, mname, sessionKey;
	private double grade;
	private Date regDate, updateDate, sessionLimit;
}
