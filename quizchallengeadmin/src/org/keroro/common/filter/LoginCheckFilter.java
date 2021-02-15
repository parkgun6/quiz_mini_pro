package org.keroro.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter({"/admin/*", "/member/*", "/qhistory/*", "/qnaboard/*", "/question/*"})
public class LoginCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		System.out.println("--------------------------------");
		System.out.println("ADMIN LOGIN FILTER ON");
		System.out.println("--------------------------------");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();		
		
		System.out.println(session);	
		
		String aid = (String)session.getAttribute("aid");
		
		// session이 없다면...
		// cannot login
		if(null == aid) {
			System.out.println("cannot login");
			res.sendRedirect("/mgr/login/check");
			return;
		}	
		
		// cookie 확인
		Cookie[] cookies = req.getCookies();

		int length = cookies.length;
		for(int i = 0; i < length; ++i){
			Cookie ck = cookies[i];
			// aid 체크
			if(true == ck.getName().equals("aid") && true == ck.getValue().equals(aid)) {
				
			}
		}
		// 얘가 어디에서 왔는지를 확인
		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
