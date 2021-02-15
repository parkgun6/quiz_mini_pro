package org.keroro.qnaboard.adminanswer.dao.test;

import org.junit.Before;
import org.junit.Test;
import org.keroro.qnaboard.adminanswer.dao.AdminAnswerDAO;
import org.keroro.qnaboard.adminanswer.domain.AdminAnswer;
import org.keroro.qnaboard.domain.QnaBoard;

import lombok.extern.log4j.Log4j;

@Log4j
public class AdminAnswerTests {
	AdminAnswerDAO dao;
	AdminAnswer answer;
	QnaBoard board;
	
	@Before
	public void AdminAnswer() {
		answer = new AdminAnswer();
		board = new QnaBoard();
		dao = new AdminAnswerDAO();
	}
	
	@Test
	public void insertTest() {
		answer = AdminAnswer.builder()
				.bno(293L)
				.aid("geon")
				.answer("test......")
				.build();
		
		dao.insertAnswerThenUpdate(answer);
	}
	
	@Test
	public void getOne() {
		Long bno = 1L;
		AdminAnswer getOne = dao.getAnswer(bno);
		log.info(getOne);
	}
	
	
//	@Test
//	public void updateState() throws Exception {
//		board.setBno(297L);
//		
//		dao.updateState(board);
//	}
//	
//	@Test
//	public void tranTest() throws Exception{
//		answer = AdminAnswer.builder()
//				.bno(295L)
//				.aid("geon")
//				.answer("test......")
//				.build();
//		
//		dao.insertAnswer(answer);
//		
//		board.setBno(295L);
//		
//		dao.updateState(board);
//	}
}
