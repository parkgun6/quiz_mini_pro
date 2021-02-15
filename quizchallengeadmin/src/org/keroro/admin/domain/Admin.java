package org.keroro.admin.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	
	private String aid;
	private String apw;
	private Date regdate;
	private Date updateDate;
	
}
