package org.keroro.qnaboard.dao.test;

import java.util.List;

import org.junit.Test;
import org.keroro.common.util.PageInfo;
import org.keroro.qnaboard.dao.QnaBoardDAO;
import org.keroro.qnaboard.domain.QnaBoard;

import lombok.extern.log4j.Log4j;

@Log4j
public class QnABoardDAOTests {
	QnaBoardDAO dao = new QnaBoardDAO();
	QnaBoard board = new QnaBoard();
	PageInfo pageInfo = new PageInfo();
	
//	@Test
//	public void getList() throws Exception {
//		List<QnaBoard> board = dao.getList(1,10);
//
//			log.info(board);
//	}
	
	@Test
	public void getOneTest() throws Exception {
		Long bno = 258L;
		QnaBoard board = dao.getOne(bno);

			log.info(board);
	}
	@Test
	public void insertTest() {
		QnaBoard board = QnaBoard.builder()
				.mid("geon")
				.qno(2L)
				.title("안녕하세요...")
				.content("Test......")
				.category(1)
				.state(1)
				.aid("geon")
				.build();
		dao.insertBoard(board);
	}
	@Test
	public void deleteBoardTest() {
		Long bno = 256L;
		dao.deleteBoard(bno);
	}
	
	@Test
	public void updateTest() throws Exception {
		QnaBoard board = QnaBoard.builder()
				.bno(252L)
				.qno(2L)
				.title("안녕하세요...")
				.content("Test......")
				.category(1)
				.state(1)
				.build();
		dao.updateBoard(board);
	}
	
	@Test
	public void acceptAnswerTest() throws Exception {
		QnaBoard board = QnaBoard.builder()
				.bno(99L)
				.state(1)
				.build();
		dao.acceptAnswer(board);
	}
}