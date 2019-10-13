package com.briup.servlet.autoLogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeforeLoginServlet
 */
@WebServlet("/beforeLoginServlet")
public class BeforeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeforeLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		String username = "";
		String password = "";
		//1. 从Cookie中获取用户名和密码
		for(Cookie c : cookies) {
			if(c.getName().equals("username") ) {
				username = c.getValue();
			}
			if(c.getName().equals("password") ) {
				password = c.getValue();
			}
		}
		System.out.println(username+password);
		//2. 如果用户名和密码不为空，认为用户记住了用户名和密码，此时跳转到LoginServlet并且携带参数,否则跳转到登录
		if(!username.isEmpty() && !password.isEmpty()) {
			request.getRequestDispatcher("/loginServlet?username="+username+"&password="+password).forward(request, response);;
		} else {
			response.sendRedirect("/servlet/toLoginServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
