package org.keroro.common.util;

import org.junit.Before;
import org.junit.Test;

import org.keroro.question.dao.QuestionDAO;

import lombok.extern.log4j.Log4j;

@Log4j
public class PageMakerTests {

	QuestionDAO qDAO;
	
	@Before
	public void ready() {
		qDAO = new QuestionDAO();
	}
	
	@Test
	public void testPaging() {
		int total = qDAO.getTotalOfQuestion();
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(1);	
		pageInfo.setPerSheet(10);	
		
		PageMaker pageMaker = new PageMaker(pageInfo, total);
		
		log.info(pageMaker);	
	}
}
