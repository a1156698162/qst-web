package com.ssp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssp.bean.MessageModel;
import com.ssp.bean.User;
import com.ssp.serivce.UserService;

public class LoginServlet extends HttpServlet{
	
	UserService userService = new UserService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String username = req.getParameter("userLogname");
		String password = req.getParameter("userPwd");
		String code = req.getParameter("validateCode");
		String verifyCode = (String) req.getSession().getAttribute("verifycode");
		
		User user = new User(username,password,code,verifyCode);
		MessageModel msg = userService.login_check(user);
		
		if(msg.getStatus() == 200) {
			req.getSession().setAttribute("user", msg.getUser());
			resp.sendRedirect("manage/main.jsp");
		}else {
			req.setAttribute("msg", msg.getMsg());
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
