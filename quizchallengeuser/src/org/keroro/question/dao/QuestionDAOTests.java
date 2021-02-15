package org.keroro.question.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.keroro.common.util.PageInfo;
import org.keroro.question.domain.Qhistory;
import org.keroro.question.domain.Question;
import org.keroro.question.dto.QhistoryDTO;
import org.keroro.question.dto.QuestionDTO;

import lombok.extern.log4j.Log4j;



@Log4j
public class QuestionDAOTests {
	QuestionDAO dao = new QuestionDAO();
	QhistoryDAO hdao = new QhistoryDAO();
	@Test
	public void getRandomQuestionTests() {
		QuestionDTO dto = new QuestionDTO();
		dto.setDifficulty(3);
		dto.setMid("mingyu");
		dto.setRandom(55);
		Question quest = dao.getRandomQuestion(dto);
		System.out.println(quest.toString());
	}
	@Test
	public void insertQhistoryTests() {
		Qhistory qhis = new Qhistory();
		qhis.setCheckAnswer("o");
		qhis.setMemberAnswer("test");
		qhis.setMid("testt");
		qhis.setQno(123L);
		dao.insertQhistory(qhis);
	}
	@Test
	public void getTotalForDTOTests() {
		QuestionDTO dto = new QuestionDTO();
		dto.setDifficulty(5);
		dto.setMid("hj");
		
		System.out.println(dao.getTotalForDTO(dto));
	}
	
	@Test
	public void testGetPaged(){
		PageInfo info = PageInfo.builder().page(1).perSheet(10).build();
		String mid = "hj";
		
		List<QhistoryDTO> list = hdao.getPageListOfMyHistory(mid, info);
		
		list.forEach(h->System.out.println(h.getHno()));
	}
	
}
