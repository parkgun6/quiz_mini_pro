package org.keroro.member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.keroro.common.controller.MultiController;
import org.keroro.member.dao.MemberDAO;
import org.keroro.member.domain.Member;
import org.keroro.question.domain.Qhistory;

import lombok.extern.log4j.Log4j;

/**
 * Servlet implementation class MemberController
 */
@Log4j
@WebServlet("/member/*")
public class MemberController extends MultiController {
	private static final long serialVersionUID = 1L;
	MemberDAO dao;
	
    public MemberController() {
        super();
        dao = new MemberDAO();
    }
    
    public String signupGET(HttpServletRequest request, HttpServletResponse response) {
    	return "member/signup";
    }
    
    public String signupPOST(HttpServletRequest request, HttpServletResponse response) {
    	String mid = request.getParameter("mid");
    	String mpw = request.getParameter("mpw");
    	String checkpw = request.getParameter("checkpw");
    	String mname = request.getParameter("mname");
    	
    	if(false == mpw.equals(checkpw)) {
    		return "re:/user/member/signup?signupfail=1";
    	}
    	
    	Member member = Member.builder().mid(mid).mpw(mpw).mname(mname).build();
    	
    	dao.signup(member);
    	log.info("signup success");
    	// 등록 성공
    	return "re:/user/login/check?signupfail=0";
    }
    
    public String indexGET() {
    	return "member/login";
    }
    
   
    
    public String loginGET(HttpServletRequest request, HttpServletResponse response) {
    	return "member/login";
    }
    
    public String loginPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	String mid = request.getParameter("mid");
    	String mpw = request.getParameter("mpw");
    	
    	
    	Member member = dao.selectMember(mid, mpw);
    	if(member==null) {
    		return "member/login";
    	}
    	session.setAttribute("member", member);
    	log.info("mid, mpw"+mid+mpw);
    	return "re:/question/submit?mid="+mid+"&grade="+3;
    	
    }
}
