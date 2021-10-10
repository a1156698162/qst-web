package com.ssp.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ssp.bean.Company;
import com.ssp.serivce.CompanyService;

@MultipartConfig
public class CompanyServlet extends HttpServlet{
	CompanyService companyService = new CompanyService();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		if(method.equals("addCompany")) {
			addCompany(req,resp);
		}else if(method.equals("showCompany")) {
			showCompany(req,resp);
		}else if(method.equals("edit")){
			editCompany(req,resp);
		}else if(method.equals("update")) {
			updateCompany(req,resp);
		}
		
	
	}

	private void updateCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String companyName = req.getParameter("companyName");
		String companyArea = req.getParameter("companyArea");
		String companySize = req.getParameter("companySize");
		String companyType = req.getParameter("companyType");
		String companyBrief = req.getParameter("companyBrief");
		int companyState = Integer.parseInt(req.getParameter("companyState"));
		int companySort = Integer.parseInt(req.getParameter("companySort"));
		Part part = req.getPart("companyPic");
		String name = part.getSubmittedFileName();
		String newName = System.currentTimeMillis() + name.substring(name.lastIndexOf("."));
		String savePath = this.getServletContext().getRealPath("/upload");
		File file = new File(savePath);
		if(!file.exists()) {
			file.mkdirs();
		}
		//3.
		part.write(savePath + "/" +newName);
		Company company = new Company(companyName,companyArea,companySize,companyType,companyBrief,companyState,companySort, "/" + newName);
		int row = companyService.update(company,id);
		if(row <= 0) {
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}else {
			showCompany(req,resp);
		}
	}

	private void editCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =Integer.parseInt(req.getParameter("id")) ;
		Company company = companyService.queryById(id);
		if(company == null) {
			resp.sendRedirect("error.jsp");
		}else {
			req.setAttribute("company", company);
			req.getRequestDispatcher("manage/companyUpdate.jsp").forward(req, resp);
		}
	}

	public void showCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Company> companyList = companyService.queryAll();
		if(companyList != null && companyList.size() > 0) {
			req.setAttribute("companyList", companyList);
			req.getRequestDispatcher("manage/companyList.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("manage/companyAdd.jsp");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	public void addCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String companyName = req.getParameter("companyName");
		String companyArea = req.getParameter("companyArea");
		String companySize = req.getParameter("companySize");
		String companyType = req.getParameter("companyType");
		String companyBrief = req.getParameter("companyBrief");
		int companyState = Integer.parseInt(req.getParameter("companyState"));
		int companySort = Integer.parseInt(req.getParameter("companySort"));
		Part part = req.getPart("companyPic");
		String name = part.getSubmittedFileName();
		String newName = System.currentTimeMillis() + name.substring(name.lastIndexOf("."));
		String savePath = this.getServletContext().getRealPath("/upload");
		File file = new File(savePath);
		if(!file.exists()) {
			file.mkdirs();
		}
		//3.
		part.write(savePath + "/" +newName);
		Company company = new Company(companyName,companyArea,companySize,companyType,companyBrief,companyState,companySort, "/" + newName);
		System.out.println(savePath);
		int row = companyService.save(company);
		
		if(row <= 0) {
			req.getRequestDispatcher("manage/companyAdd.jsp").forward(req, resp);
		}else {
			showCompany(req,resp);
		}
	}

}
