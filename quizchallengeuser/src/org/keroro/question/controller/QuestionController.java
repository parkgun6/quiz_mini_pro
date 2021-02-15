package org.keroro.question.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.keroro.common.controller.MultiController;
import org.keroro.question.dao.QhistoryDAO;
import org.keroro.question.dao.QuestionDAO;
import org.keroro.question.domain.Qhistory;
import org.keroro.question.domain.Question;
import org.keroro.question.dto.QhistoryDTO;
import org.keroro.question.dto.QuestionDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/challenge/*")
public class QuestionController extends MultiController {
	private static final long serialVersionUID = 1L;

	private QuestionDAO dao;
	private QhistoryDAO hdao;
	
	public QuestionController() {
		super();
		dao = new QuestionDAO();
		hdao = new QhistoryDAO();
	}
	
	// Challenge에서 문제 풀기 시작
	public String questionGET(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		String grade = request.getParameter("grade");
		
		log.info("mid="+mid+", grade="+grade);
		
		int dif =((int) (Math.random()*3))+Integer.parseInt(grade);// grade 1~3 (difficulty 1~5)
		log.info("dif="+dif);
		QuestionDTO dto = QuestionDTO.builder().mid(mid).difficulty(dif).build();	
		
		// 토탈값 구하기
		int total = dao.getTotalForDTO(dto);
	
		// 랜덤 구하기
		int random = (int)(Math.random() * total) + 1;
		log.info(random);	
		dto.setRandom(random);

		// 문제 랜덤으로 뽑아오기
		Question q = dao.getRandomQuestion(dto);
		log.info(q.toString());
		request.setAttribute("q", q);
		request.setAttribute("grade", grade);
		
		
		return "challenge/question";
	}
	
	// Challenge에서 답변 제출
	public String questionPOST(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		Long qno = Long.parseLong(request.getParameter("qno"));
		String mid = (String)session.getAttribute("mid");
		String userAnswer = request.getParameter("userAnswer");
		userAnswer = (userAnswer == null || userAnswer.isEmpty()) ? "n/a" : userAnswer; 
		
		String grade = request.getParameter("grade");
		log.info("mid="+mid+", qno="+qno+", grade="+grade);
		log.info(userAnswer);

		// 정답이라면
		Question quest = dao.getOneQuestion(qno);		
		String check = (quest.getAnswer().toLowerCase()).equals(userAnswer.toLowerCase()) ?"o":"x"; 
		log.info("checkAnswer : "+check);
			
		Qhistory qhis = new Qhistory();
		qhis.setCheckAnswer(check);
		qhis.setMemberAnswer(userAnswer);
		qhis.setMid(mid);
		qhis.setQno(quest.getQno());
		log.info(""+qhis.toString());
		dao.insertQhistory(qhis);	
		
		// result GET
		return "re:result?qno="+qno+"&grade="+grade ;
	}
	
	public String resultGET(HttpServletRequest request, HttpServletResponse response) {
		log.info("resultGET");
		String grade = request.getParameter("grade");
		Long qno = Long.parseLong(request.getParameter("qno"));
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		log.info("mid="+mid+", qno="+qno+", grade="+grade);
		QhistoryDTO dto = hdao.getMyHistory(mid, qno);
		
		request.setAttribute("history", dto);
		request.setAttribute("grade", grade);
		
		return "challenge/result";
	}
	
	
	
}
