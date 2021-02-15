package org.keroro.question.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.keroro.common.controller.MultiController;
import org.keroro.common.util.PageInfo;
import org.keroro.common.util.PageMaker;
import org.keroro.question.dao.QhistoryDAO;
import org.keroro.question.dao.QuestionDAO;
import org.keroro.question.dto.QhistoryDTO;

import lombok.Builder.Default;
import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/myhistory/*")
public class QhistoryController extends MultiController{	
	private static final long serialVersionUID = 1L;
	@Default
	private QhistoryDAO dao = new QhistoryDAO();
	
	public String listGET(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int page = getInt(request, 1, "page");
		int perSheet = getInt(request, 10, "perSheet");
		String mid = (String)session.getAttribute("mid");
		// test mid
	
		log.info("mid = " + mid);
		
		if(null == mid) {
			return "re:/user/login/check";					
		}

		PageInfo info = new PageInfo();
		info.setPage(page);
		info.setPerSheet(perSheet);

		log.info("qhistory listGET PageInfo : " + info);

		PageMaker pageMaker = new PageMaker(info, dao.getTotalOfMyHistory(mid));
		
		List<QhistoryDTO> list = dao.getPageListOfMyHistory(mid, info);
		
		request.setAttribute("pageMaker", pageMaker);
		request.setAttribute("list", list);
		
		return "myhistory/list";
	}
	
	
	
}
