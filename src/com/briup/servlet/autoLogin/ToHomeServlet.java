package com.briup.servlet.autoLogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.servlet.bean.User;

/**
 * 判断session中是否包含用户信息，如果有跳转到home.jsp。如果没有跳转到BeforeLoginServlet
 */
@WebServlet("/toHomeServlet")
public class ToHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Object o = session.getAttribute("user");
		if(o != null && o instanceof User) {
			// 认为user在session中有，用户已经登录，可以查看
			request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
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
