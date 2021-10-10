package com.ssp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssp.bean.User;

public class UserDao {

	public Connection getConnection() throws Exception {
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qst_web", "root", "abc123");
		return conn;
	}
	

	public User queryByNameAndPassword(User user) {
		User u = null;
		
		try {
			Connection conn = getConnection();
			String sql = "select * from tb_users where user_logname = ? and user_pwd = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User(rs.getString("user_logname"),rs.getString("user_pwd"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}


	public int save(User user) {
		int row = 0;
		try {
			Connection conn = getConnection();
			String sql = "INSERT INTO tb_users(user_logname, user_pwd,user_email, role_id, user_state) VALUES(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getEmail());
			ps.setInt(4,user.getUserRole());
			ps.setInt(5,user.getUserState());
			row = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}


	public Integer queryUserTotalCount() {
		int totalUserCount = 0;
		try {
			Connection conn = getConnection();
			String sql = "select * from tb_users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				totalUserCount++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalUserCount;
	}


	public List<User> queryUserPageList(int begin,int pageSize) {
		List<User> userPageList = new ArrayList<User>();
		try {
			Connection conn = getConnection();
			String sql = "select * from tb_users limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, begin);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User(rs.getString("user_logname"),rs.getString("user_pwd"),rs.getString("user_email"),rs.getInt("role_id"),rs.getInt("user_state"));
				userPageList.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userPageList;
	}

}
