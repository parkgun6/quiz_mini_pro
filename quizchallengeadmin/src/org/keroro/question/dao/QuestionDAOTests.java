package org.keroro.question.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.keroro.common.util.ExcelReader;
import org.keroro.common.util.PageInfo;
import org.keroro.usermember.domain.Member;
import org.keroro.question.domain.Qhistory;
import org.keroro.question.domain.Question;
import org.keroro.question.dto.QhistoryDTO;
import org.keroro.question.dto.QuestionDTO;
import org.keroro.question.util.QuestionExcelLoader;

import lombok.extern.log4j.Log4j;

@Log4j
public class QuestionDAOTests {
	private QuestionDAO dao;
	
	@Before
	public void ready() {
		dao = new QuestionDAO();
	}
	
	@Test
	public void testModifyQuestion() {
		Long qno = 131075L;
		
		Question q1 = Question.builder().qno(qno).aid("mingyuAdmin").quiz("modifyQuestion")
				.answer("modifyAnswer").deprecated("n").difficulty(5).build();
		
		dao.modifyQuestion(q1);
		
		Question q2 = dao.getOneQuestion(qno);
		log.info(q2);
	}
	
	@Test
	public void testGetOneQuestion() {
		Question q = dao.getOneQuestion(131075L);
		
		log.info(q);
	}
	
	@Test
	public void testGetPagedListOfQuestion() {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(24);	

		try {
			List<Question> list = dao.getPagedListOfQuestion(pageInfo);
			list.forEach(q->log.info(q.getQno()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetTotal() {	
		try {
			QuestionDTO dto = QuestionDTO.builder().difficulty(1).mid("mingyu").build();
			int total = dao.getTotalOfQuestion(dto);
			int random = (int)(Math.random() * total);
			
			log.info(total);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertQuestion() {
		try {
			Question q = Question.builder()
					.aid("mingyuAdmin").quiz("insertTest").answer("insertAnswer").difficulty(1)
					.build();
			
			dao.insertQuestion(q);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertQuestionByExcel() {
		try {
			QuestionExcelLoader loader = new QuestionExcelLoader("C:\\upload\\test.xlsx");

			List<Question> list = loader.load();
			
			for(Question q : list) {
				dao.insertQuestion(q);				
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//===========================QHISTORY TEST========================//
	//===========================QHISTORY TEST========================//
	//===========================QHISTORY TEST========================//
	@Test
	public void testGetPagedListOfQhistory() {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(2);	

		try {
			List<Qhistory> list = dao.getPagedListOfQhistory(pageInfo);
			list.forEach(q->log.info(q.getHno()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertQhistory() {
		try {		
			Qhistory h = Qhistory.builder().mid("mingyu").memberAnswer("4321").qno(131075L).checkAnswer("X").build();
			
			dao.insertQhistory(h);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//===========================Question DTO TEST========================//
	//===========================Question DTO TEST========================//
	//===========================Question DTO TEST========================//
	
	@Test
	public void testGetAllListOfQhistoryDTO() {
		List<QhistoryDTO> list = dao.getAllListOfQhistoryDTO();
		list.forEach(dto->log.info(dto.getHno() ));
	}
	
	@Test
	public void testGetPagedListOfQhistoryDTO() {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(2);	

		try {
			List<QhistoryDTO> list = dao.getPagedListOfQhistoryDTO(pageInfo);
			list.forEach(q->log.info(q.getHno()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
