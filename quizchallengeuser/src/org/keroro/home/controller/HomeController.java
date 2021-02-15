package org.keroro.home.controller;


import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.keroro.common.controller.MultiController;
import org.keroro.member.dao.MemberDAO;
import org.keroro.member.dto.MemberDTO;
import org.keroro.member.dto.ScoreDTO;
import org.keroro.question.controller.QhistoryController;

import lombok.Builder.Default;
import lombok.extern.log4j.Log4j;


@Log4j
@WebServlet("/home/*")
public class HomeController extends MultiController{	
	private static final long serialVersionUID = 1L;
	@Default
	private MemberDAO memberDAO = new MemberDAO();
	
	
	
	public String mainGET(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		
		request.setAttribute("mid", mid);
		

		try {
			// list를 던지자
			List<MemberDTO> list = memberDAO.getPercentList();
			MemberDTO dto = memberDAO.getPercentOne(mid);
			int total = memberDAO.getTotal();
			List<ScoreDTO> scoreList = memberDAO.getScoreList(mid);
			// 종합 평균 구하기
			double totalAvg = 0;
			int totalCount = 0;
			for(int i = 0; i < scoreList.size(); ++i) {
				totalAvg += scoreList.get(i).getTotalScore();
				totalCount += scoreList.get(i).getTotal();
			}
			
			totalAvg /= totalCount;
			totalAvg = (int)(totalAvg * 1000) / 1000.0;
			
			
			request.setAttribute("list", list);
			request.setAttribute("dto", dto);			
			request.setAttribute("total", total);			
			request.setAttribute("totalAvg", totalAvg);			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "home/main";
	}
}
