package org.keroro.usermember.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	
	private String mid;
	private String mpw;
	private String mname;
	private double grade;
	private Date regdate;
	private Date updateDate;
	
}
