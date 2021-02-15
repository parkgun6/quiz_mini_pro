package org.keroro.question.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keroro.common.controller.MultiController;
import org.keroro.question.dao.QuestionDAO;
import org.keroro.question.domain.Qhistory;
import org.keroro.question.domain.Question;
import org.keroro.question.dto.QuestionDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/challenge/*")
public class ChallengeController extends MultiController {
	private static final long serialVersionUID = 1L;

	private QuestionDAO dao;
	
	public ChallengeController() {
		super();
		dao = new QuestionDAO();
	}
	
	// Challenge에서 문제 풀기 시작
	public String submitGET(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		// 1. 멤버 찾기
		// 2. 멤버가 선택한 난이도에 따라서 dif 넣기
		int dif = 3;
		
		QuestionDTO dto = QuestionDTO.builder().mid(mid).difficulty(dif).build();	
		
		// 토탈값 구하기
		int total = dao.getTotalForDTO(dto);
	
		// 랜덤 구하기
		int random = (int)(Math.random() * total) + 1;
		log.info(random);	
		dto.setRandom(random);

		// 문제 랜덤으로 뽑아오기
		Question q = dao.getRandomQuestion(dto);
				
		request.setAttribute("dto", dto);
		request.setAttribute("question", q);
		
		return "challenge/submit";
	}
	
	// Challenge에서 답변 제출
	public String submitPOST(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String memberAnswer = request.getParameter("memberAnswer");
		Long qno = getLong(request, 0L, "qno");
			
		if(0L == qno) {
			return "re:/error/";
		}
		
		Question question = dao.getOneQuestion(qno);
		
		String checkAnswer = "";
		
		// 정답의 경우
		if(true == memberAnswer.equals(question.getAnswer())) {
			checkAnswer = "O";
		} else {
			checkAnswer = "X";
		}	
		
		Qhistory h = Qhistory.builder().mid(mid).memberAnswer(memberAnswer).qno(qno).checkAnswer(checkAnswer).build();
	
		dao.insertQhistory(h);
		
		return "challenge/submit";
	}
}
