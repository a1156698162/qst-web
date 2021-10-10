package com.ssp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssp.bean.User;
import com.ssp.serivce.UserService;

public class AddUserServlet extends HttpServlet{

	UserService userService = new UserService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String userLogname = req.getParameter("userLogname");
		String userPwd = req.getParameter("userPwd");
		String userEmail = req.getParameter("userEmail");
		int userRole = Integer.parseInt(req.getParameter("userRole"));
		int userState = Integer.parseInt(req.getParameter("userState"));
		User user = new User(userLogname,userPwd,userEmail,userRole,userState);
		int row = userService.save(user);
		if(row <= 0) {
			req.getRequestDispatcher("userAdd.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("manage/userList.jsp");
		}
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
