package org.keroro.question.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keroro.common.controller.MultiController;
import org.keroro.common.util.PageInfo;
import org.keroro.common.util.PageMaker;
import org.keroro.question.dao.QuestionDAO;
import org.keroro.question.domain.Qhistory;
import org.keroro.question.domain.Question;
import org.keroro.question.dto.QhistoryDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/qhistory/*")
public class QhistoryController extends MultiController {
	private static final long serialVersionUID = 1L;

	private QuestionDAO dao;

	public QhistoryController() {
		super();
		dao = new QuestionDAO();
	}

	// 게시판 목록 출력
	public String listGET(HttpServletRequest request, HttpServletResponse response) {
		log.info("qhistory listGET"); // log.debug();

		try {
			int page = getInt(request, 1, "page");
			int perSheet = getInt(request, 10, "perSheet");
			// test total

			PageInfo info = new PageInfo();
			info.setPage(page);
			info.setPerSheet(perSheet);

			log.info("qhistory listGET PageInfo : " + info);

			PageMaker pageMaker = new PageMaker(info, dao.getTotalOfQhistory());

			List<QhistoryDTO> qhistories = dao.getPagedListOfQhistoryDTO(info);

			log.info("questionDAO.getPagedListOfQhistory()");

			// 이거 들고 가라
			request.setAttribute("qhistories", qhistories);
			request.setAttribute("pageMaker", pageMaker);
		} catch (Exception e) {
			e.printStackTrace();
			return "re:/error/";
		}

		return "qhistory/list";
	}
}
