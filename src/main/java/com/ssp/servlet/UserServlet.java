package com.ssp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssp.bean.Page;
import com.ssp.bean.User;
import com.ssp.serivce.UserService;

public class UserServlet extends HttpServlet{
	
	private UserService userService = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		if("page".equals(method)) {
			page(req,resp); 
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	private void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pn = req.getParameter("pn");
		String ps = req.getParameter("pageSize");
		int pageNo = 1;
		int pageSize = 3;
		if(pn != null) {
			pageNo = Integer.parseInt(pn);
		}else {
			
		}
		if(ps != null) {
			pageSize = Integer.parseInt(ps);
		}
		
		Page<User> userPage = userService.queryForUserPage(pageNo,pageSize);
//		System.out.println(userPage);
		req.setAttribute("userPage", userPage);
		req.getRequestDispatcher("manage/userList.jsp").forward(req, resp);
	}

}
