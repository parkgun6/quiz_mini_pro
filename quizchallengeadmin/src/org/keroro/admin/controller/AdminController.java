package org.keroro.admin.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keroro.admin.dao.AdminDAO;
import org.keroro.admin.domain.Admin;
import org.keroro.common.controller.MultiController;
import org.keroro.common.util.PageInfo;
import org.keroro.common.util.PageMaker;

import lombok.Builder.Default;
import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/admin/*")
public class AdminController extends MultiController{
	
	@Default
	AdminDAO dao = new AdminDAO();

	//관리자 홈 화면
	public String homeGET(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		// 쿠키 확인
		
		try {
			
			log.info("home...............");

			Admin admin = dao.getOne("mw");
			
			log.info(admin);
			
			req.setAttribute("admin", admin);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "admin/home";
		
	}


	//관리자목록 조회
	public String listGET(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		try {
			
			log.info("list......................");
			
			PageInfo pageInfo = new PageInfo();

			//웹에서 가장 오류가 많이나는 Inter를 따로 뺀다.
			pageInfo.setPage(getInt(req,1,"page"));
			pageInfo.setPerSheet(getInt(req,10,"perSheet"));
			
			int total = dao.getTotal();
			
			PageMaker pageMaker = new PageMaker(pageInfo, total);
			
			List<Admin> adminList = dao.getList(pageInfo);
			
			adminList.forEach(a -> log.info(a));
			
			req.setAttribute("pageMaker", pageMaker);
			req.setAttribute("adminList", adminList);
			
			return "admin/list";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
	}	

	//관리자목록 검색
	public String listSelectGET(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		try {
			
			log.info("listSelect......................");
			
			String aid = req.getParameter("aid");
			
			Admin admin = dao.getOne(aid);
			
			req.setAttribute("admin", admin);
			
			return "admin/listSelect";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
	}
	
	//관리자정보 조회
	public String infoGET(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		try {
			
			log.info("admin...............");
			
			String aid = req.getParameter("aid");
			
			Admin admin = dao.getOne(aid);
			
			log.info(admin);
			
			req.setAttribute("admin", admin);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "admin/info";
		
	}
	
	//관리자정보 수정
	public String modifyGET(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		try {
			
			log.info("admin...............");
			
			String aid = req.getParameter("aid");
			
			Admin admin = dao.getOne(aid);
			
			log.info(admin);
			
			req.setAttribute("admin", admin);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "admin/modify";
		
	}

	//회원정보 삭제
	public String deletePOST(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		try {
			
			String aid = req.getParameter("aid");
			
			dao.delete(aid);
			
			log.info(aid);
			
			return "re:admin/list";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
	}	
	
	//관리자정보 수정완료
	public String modifyPOST(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		try {
			
			log.info("admin...............");
			
			String aid = req.getParameter("aid");
			String apw = req.getParameter("apw");
			
			Admin admin = Admin.builder().aid(aid).apw(apw).build();
			
			dao.update(admin);
			
			log.info(admin);

			return "re:admin/info?aid=" + admin.getAid();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
