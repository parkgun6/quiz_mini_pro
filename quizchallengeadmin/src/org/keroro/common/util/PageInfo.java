package org.keroro.common.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo {
	@Default
	private int page = 1; // 페이지 번호
	@Default
	private int perSheet = 10; // 페이지 하나당 들어갈 수 있는 게시판의 개수
	
	private int state;
	private int category = 0;
	
	public void setPage(int number) {
		if(0 >= number) {
			this.page = 1;
			return;
		}
		
		this.page = number;
	}
	
	public void setPerSheet(int number) {
		if(100 <= number) {
			this.perSheet = 100;
			return;
		}
		
		if (10 > number) {
			this.perSheet = 10;
			return;
		}
		
		this.perSheet = number;
	}
	
	
	public void setState(int state) {
		this.state = state;
	}
	
	
}
