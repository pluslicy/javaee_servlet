package com.briup.servlet.autoLogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.servlet.bean.User;

/**
 * 编写代码获取用户名密码
	验证用户信息是否正确
	如果正确跳转到home.jsp （如果用户下次选中自动登录，用户信息会记录在cookie中
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String isAutoLogin = request.getParameter("isAutoLogin");
		System.out.println(isAutoLogin);
		// 假设用户名密码必须为admin/admin
		if(username.equals("admin") && password.equals("admin")) {
			// 登录成功，将用户信息放入到Session中
			User user = new User();
			user.setName(username);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			// 判断是否记住密码，如果记住密码将密码保存到cookie中
			if(isAutoLogin!=null && isAutoLogin.equals("on")) {
				Cookie cookie_username = new Cookie("username", username);
				Cookie cookie_password = new Cookie("password", password);
				cookie_username.setMaxAge(24*60*60);
				cookie_password.setMaxAge(24*60*60);
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
			}
			// 跳转到ToHomeServlet
			response.sendRedirect("/servlet/toHomeServlet");
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
