package org.keroro.member.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.keroro.common.controller.MultiController;
import org.keroro.member.dao.MemberDAO;
import org.keroro.member.domain.Member;

import lombok.Builder.Default;
import lombok.extern.log4j.Log4j;


@Log4j
@WebServlet("/login/*")
public class LoginController extends MultiController {
	private static final long serialVersionUID = 1L;
	
	@Default
	private MemberDAO dao = new MemberDAO();
	
	private Map<String, Object> map;
	
	public String logoutPOST(HttpServletRequest request, HttpServletResponse response) {

		String mid = request.getParameter("mid");		
		request.getSession().invalidate();
		
		 Cookie[] cookies = request.getCookies();
         Cookie loginCookie = null;
         
         //loginCookie 찾기
         for (Cookie cookie : cookies) {
				
         	if(cookie.getName().equals("loginCookie"))
         		
         		loginCookie = cookie;
         		log.info(loginCookie);
         		
			}//foreach
         
         if(loginCookie != null) {
        	 
        	 loginCookie.setPath("/");
             // 쿠키는 없앨 때 유효시간을 0으로 설정하는 것 !!! invalidate같은거 없음.
             loginCookie.setMaxAge(0);
             // 쿠키 설정을 적용한다.
             response.addCookie(loginCookie);
              
             // 사용자 테이블에서도 유효기간을 현재시간으로 다시 세팅해줘야함
             Date date =new Date(System.currentTimeMillis());
             
				map = new HashMap<>();
             
				map.put("mid", mid);
				map.put("sessionKey", loginCookie.getName());
				map.put("sessionLimit", date);
				
				try {
					
					dao.keepLogin(map);
					log.info(map);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}            
        	 
         }
		
		return "re:/user/login/check";
	}
	
	public String checkGET(HttpServletRequest request, HttpServletResponse response) {
		log.info("login checkGET");
		String mid = request.getParameter("mid");
		String loginFail = request.getParameter("loginFail");
		
		log.info(mid);
		
		//mid가 없을 경우 쿠키 확인
		if(mid == null ) {
			// 우리가 만들어 논 쿠키를 꺼내온다. loginCookie
            Cookie[] cookies = request.getCookies();
            Cookie loginCookie = null;
            
            //loginCookie 찾기
            for (Cookie cookie : cookies) {
				
            	if(cookie.getName().equals("loginCookie"))
            		
            		loginCookie = cookie;
            		log.info(loginCookie);
            		
			}//foreach
            
            // 쿠키가 존재하는 경우
			if(loginCookie != null) {
				
                try {
                	// loginCookie의 값을 꺼내오고 -> 즉, 저장해논 세션Id를 꺼내오고
                	String sessionKey = loginCookie.getValue();
                	// 세션Id를 checkUserWithSessionKey에 전달해 이전에 로그인한적이 있는지 체크하는 메서드를 거쳐서
                	// 유효시간이 > now() 인 즉 아직 유효시간이 지나지 않으면서 해당 sessionId 정보를 가지고 있는 사용자 정보를 반환한다.
					Member member = dao.checkSessionKey(sessionKey);
					
					if ( member != null ){// 그런 사용자가 있다면
	                    // 세션을 생성시켜 준다.
						HttpSession session = request.getSession();
	                    session.setAttribute("mid", member.getMid());
	                    session.setAttribute("mpw", member.getMpw());
	            		
	                    //이전페이지 url
	            		String referer = request.getHeader("referer");
	            		log.info("referer:" + referer);
	            		
	            		if(referer != null) {
	            			
	            			String[] str = referer.split(":");
	            			log.info(str);
	            			referer = str[2];
	            			referer = referer.substring(4);
	            			log.info(referer);
	            			return "re:" + referer;
	            			
	            		}
	            		
	                    return "re:/user/home/main";
	                   
	                }					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		//mid & Cookie 둘다 없을 경우
		}else {			
			log.info("mid : " + mid);
			log.info("loginFail : " + loginFail);
			
			request.setAttribute("mid", mid);
			request.setAttribute("loginFail", loginFail);			
		}
		
		return "login/check";
		
	}
	
	public String checkPOST(HttpServletRequest request, HttpServletResponse response) {
		log.info("login checkPOST");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		// Member member = Admin.builder().aid(mid).apw(mpw).build();
		
		Member result = dao.selectMember(mid, mpw);
		log.info(result);

		// 세션
		HttpSession session = request.getSession();	
		
		// 로그인 되었다는 뜻
		if(null != result) {			
			// remeber me 확인
			String remember = request.getParameter("remember");
			if(null != remember &&  remember.equals("ok")) {
				log.info("cookie ok");
				
				String cookieNum = Double.toString(Math.random() * 1000000);
				// 쿠키 사용한다는게 체크되어 있으면...
                // 쿠키를 생성하고 현재 로그인되어 있을 때 생성되었던 세션의 id를 쿠키에 저장한다.
				// 쿠키 발행
                Cookie cookie =new Cookie("loginCookie", session.getId());	
				// 일주일 유통기한
                cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24 * 7);
				
				map = new HashMap<>();
				
				int amount = 60 * 60 * 24 * 7;
				
				Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
				
				map.put("mid", mid);
				map.put("sessionKey", session.getId());
				map.put("sessionLimit", sessionLimit);
				
				try {
					
					dao.keepLogin(map);
					log.info(map);
//					return "re:" + referer;
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				response.addCookie(cookie);
				
			}	
			
			session.setAttribute("mid", mid);
			
			log.info("login success");
			return "re:/user/home/main";
		}
		
		log.info("login fail");
		// 로그인 실패		
		return "re:/user/login/check?loginFail=1&mid=" + mid;
	}
}
