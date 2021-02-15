package org.keroro.question.controller;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keroro.common.controller.MultiController;
import org.keroro.common.util.PageInfo;
import org.keroro.common.util.PageMaker;
import org.keroro.question.dao.QuestionDAO;
import org.keroro.question.domain.Question;
import org.keroro.question.dto.QhistoryDTO;
import org.keroro.question.dto.QuestionDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/question/*")
@MultipartConfig(location = "C:\\upload")
public class QuestionController extends MultiController {
	private static final long serialVersionUID = 1L;

	private QuestionDAO dao;

	public QuestionController() {
		super();
		dao = new QuestionDAO();
	}

	// 문제 수정 GET
	public String modifyGET(HttpServletRequest request, HttpServletResponse response) {
		Long qno = getLong(request, 0L, "qno");
		log.info(qno);
		if(0L == qno) {
			return "re:/error";
		}
		
		Question question = dao.getOneQuestion(qno);
		
		request.setAttribute("question", question);
		
		return "question/modify";
	}
	// 문제 수정 POST
	public String modifyPOST(HttpServletRequest request, HttpServletResponse response) {
		log.info("question modifyPOST"); // log.debug();
		
		String aid = request.getParameter("aid"); // 인자로 name="AA" 넣으면 value="" 가 반환도니다. 
		String quiz = request.getParameter("quiz");
		String answer = request.getParameter("answer");
		int dif = getInt(request , 3, "difficulty");
		Long qno = getLong(request, 0L, "qno");
		
		if(0L == qno) {
			return "re:/error";
		}
		
		Question question = Question.builder().qno(qno)
				.aid(aid).quiz(quiz).answer(answer).difficulty(dif).build();
		
		log.info("question : " + question);
		
		dao.modifyQuestion(question);
		
		return "re:/question/view?qno=" + qno;
	}
	
	// 문제 뷰
	public String viewGET(HttpServletRequest request, HttpServletResponse response) {
		Long qno = getLong(request, 0L, "qno");
		log.info(qno);
		if(0L == qno) {
			return "re:/error";
		}
		
		Question question = dao.getOneQuestion(qno);
		
		request.setAttribute("question", question);
		
		
		
		return "question/view";
	}
	
	// 문제 등록 1
	public String registerGET(HttpServletRequest request, HttpServletResponse response) {
		log.info("question registerGET"); // log.debug();
		
		return "question/register";
	}
	
	// 문제 등록 1 처리
	public String registerPOST(HttpServletRequest request, HttpServletResponse response) {
		log.info("question registerPOST");
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			String aid = request.getParameter("aid");
			String quiz = request.getParameter("quiz");
			String answer = request.getParameter("answer");
			int dif = getInt(request, 1, "difficulty");
			
			Question question = 
				Question.builder().aid(aid).quiz(quiz).answer(answer).difficulty(dif).build();
		
			dao.insertQuestion(question);

		} catch (Exception e) {
			e.printStackTrace();
			return "re:/error";
		}
		
		return "re:/question/list";
		// javax.servlet.http.Part filePart = request.getPart("file");
	}
	
	// 문제 등록 2
	public String registerExcelGET(HttpServletRequest request, HttpServletResponse response) {
		log.info("question registerExcelGET"); // log.debug();
		
		return "question/registerExcel";
	}
	
	// 문제 등록 1 처리
	public String registerExcelPOST(HttpServletRequest request, HttpServletResponse response) {
		log.info("question registerExcelPOST");
		
		try{
			javax.servlet.http.Part filePart = request.getPart("file");
			String fileName = filePart.getSubmittedFileName();
			filePart.write(fileName);
			
			dao.insertQuestionByExcel("C:\\upload\\" + fileName);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "re:/error";
		}
		
		return "re:/question/list";
		
	}
	
	// 문제 목록 출력
	public String listGET(HttpServletRequest request, HttpServletResponse response) {
		log.info("question listGET"); // log.debug();

		try {
			int page = getInt(request, 1, "page");
			int perSheet = getInt(request, 10, "perSheet");
			// test total

			PageInfo info = new PageInfo();
			info.setPage(page);
			info.setPerSheet(perSheet);

			log.info("question listGET PageInfo : " + info);

			PageMaker pageMaker = new PageMaker(info, dao.getTotalOfQuestion());

			List<Question> questions = dao.getPagedListOfQuestion(info);

			log.info("questionDAO.getPagedListOfQuestion()");

			// 이거 들고 가라
			request.setAttribute("questions", questions);
			request.setAttribute("pageMaker", pageMaker);
		} catch (Exception e) {
			e.printStackTrace();
			return "re:/error/";
		}

		return "question/list";
	}

}
