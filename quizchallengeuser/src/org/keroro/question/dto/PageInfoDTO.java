package org.keroro.question.dto;

import org.keroro.common.util.PageInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageInfoDTO {
	@Default
	private int page = 1; // 페이지 번호
	@Default
	private int perSheet = 10; // 페이지 하나당 들어갈 수 있는 게시판의 개수
	
	private String mid;
	
	
}
