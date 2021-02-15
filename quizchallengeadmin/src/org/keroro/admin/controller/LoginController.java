package org.keroro.admin.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.keroro.admin.dao.AdminDAO;
import org.keroro.admin.domain.Admin;
import org.keroro.common.controller.MultiController;
import org.keroro.question.controller.ChallengeController;

import lombok.Builder.Default;
import lombok.extern.log4j.Log4j;


@Log4j
@WebServlet("/login/*")
public class LoginController extends MultiController {
	private static final long serialVersionUID = 1L;
	
	@Default
	AdminDAO dao = new AdminDAO();
	
	public String logoutPOST(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();		
		return "re:/mgr/login/check";
	}
	
	public String checkGET(HttpServletRequest request, HttpServletResponse response) {
		return "login/check";
	}
	
	public String checkPOST(HttpServletRequest request, HttpServletResponse response) {
		log.info("login checkPOST");
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		
		Admin admin = Admin.builder().aid(aid).apw(apw).build();
		
		Admin result = dao.getAdmin(admin);
		log.info(result);

		// 로그인 되었다는 뜻
		if(null != result) {			
			// remeber me 확인
			String remember = request.getParameter("remember");
			if(null != remember &&  remember.equals("ok")) {
				log.info("cookie ok");
				
				// 쿠키 발행
				Cookie ck = new Cookie("aid", aid);
				// 1시간 유통기한
				ck.setMaxAge(60*60);				
				response.addCookie(ck);			
			}		
			// 세션
			HttpSession session = request.getSession();
			session.setAttribute("aid", aid);
			
			return "re:/mgr/admin/home";
		}
		
		// 로그인 실패		
		return "re:/mgr/login/check";
	}
}
