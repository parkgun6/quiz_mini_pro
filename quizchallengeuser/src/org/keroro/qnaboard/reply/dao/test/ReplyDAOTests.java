package org.keroro.qnaboard.reply.dao.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.keroro.qnaboard.reply.dao.ReplyDAO;
import org.keroro.qnaboard.reply.domain.Reply;

import lombok.extern.log4j.Log4j;

@Log4j
public class ReplyDAOTests {
	
	ReplyDAO dao = new ReplyDAO();
	Reply reply = new Reply();
	
	@Test
	public void testGetAll() throws Exception {
		Long bno = 264L;
		List<Reply> reply = dao.getAll(bno);
		
		log.info(reply);
	}
	
	@Test
	public void testInsert() throws Exception{
		Reply reply = Reply.builder()
				.bno(270L)
				.mid("geon")
				.reply("하이염")
				.build();
		dao.insertReply(reply);
	}

	@Test
	public void deleteBoardTest() {
		Long rno = 37L;
		dao.deleteReply(rno);
	}
	
}
