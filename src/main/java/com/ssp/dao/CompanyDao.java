package com.ssp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssp.bean.Company;

public class CompanyDao {
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qst_web", "root", "abc123");
		return conn;
	}
	public int save(Company company) {
		int row = 0;
		try {
			Connection conn = getConnection();
			String sql = "INSERT INTO tb_company(company_name,company_area,company_size,company_type,company_brief,company_state,company_sort,company_pic) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, company.getCompanyName());
			ps.setString(2, company.getCompanyArea());
			ps.setString(3, company.getCompanySize());
			ps.setString(4, company.getCompanyType());
			ps.setString(5, company.getCompanyBrief());
			ps.setInt(6, company.getCompanyState());
			ps.setInt(7, company.getCompanySort());
			ps.setString(8, company.getCompanyPic());
			row = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	public List<Company> queryAll() {
		List<Company>companyList = new ArrayList<Company>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Company company = null;
		try {
			conn = getConnection();
			String sql = "select * from tb_company";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				company = new Company(rs.getInt("company_id"),rs.getString("company_name"),rs.getString("company_area"),rs.getString("company_size"),rs.getString("company_type"),rs.getString("company_brief"),rs.getInt("company_state"),rs.getInt("company_sort"),rs.getInt("company_viewnum"),rs.getString("company_pic"));
				companyList.add(company);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companyList;
	}
	public Company queryById(int id) {
		Company company = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from tb_company where company_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				company = new Company(rs.getInt("company_id"),rs.getString("company_name"),rs.getString("company_area"),rs.getString("company_size"),rs.getString("company_type"),rs.getString("company_brief"),rs.getInt("company_state"),rs.getInt("company_sort"),rs.getInt("company_viewnum"),rs.getString("company_pic"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return company;
	}
	public int update(Company company, int id) {
		int row = 0;
		try {
			Connection conn = getConnection();
			String sql = "update tb_company set company_name=?,company_area=?,company_size=?,company_type=?,company_brief=?,company_state=?,company_sort=?,company_viewnum=?,company_pic=? where company_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, company.getCompanyName());
			ps.setString(2, company.getCompanyArea());
			ps.setString(3, company.getCompanySize());
			ps.setString(4, company.getCompanyType());
			ps.setString(5, company.getCompanyBrief());
			ps.setInt(6, company.getCompanyState());
			ps.setInt(7, company.getCompanySort());
			ps.setInt(8, company.getCompanyViewnum());
			ps.setString(9, company.getCompanyPic());
			ps.setInt(10, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

}
