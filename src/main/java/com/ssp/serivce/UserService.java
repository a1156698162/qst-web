package com.ssp.serivce;

import java.util.List;

import com.ssp.bean.MessageModel;
import com.ssp.bean.Page;
import com.ssp.bean.User;
import com.ssp.dao.UserDao;

public class UserService {
	UserDao userDao = new UserDao();
	public MessageModel login_check(User user) {
		MessageModel model = new MessageModel();
		if(user.getUsername() == null||"".equals(user.getUsername())) {
			model.setStatus(100);
			model.setMsg("用户名不能为空！");
			return model;
		}
		if(user.getPassword() == null||"".equals(user.getPassword())) {
			model.setStatus(100);
			model.setMsg("密码不能为空！");
			return model;
		}
		if(user.getCode() == null || "".equals(user.getCode())) {
			model.setStatus(100);
			model.setMsg("验证码不能为空！");
			return model;
		}
		if(!user.getCode().equals(user.getSessionCode())) {
			model.setStatus(100);
			model.setMsg("验证码不正确！");
			return model;
		}
		User u = userDao.queryByNameAndPassword(user);
		if(u == null) {
			model.setStatus(100);
			model.setMsg("用户名或密码不正确！");
			return model;
		}
		model.setUser(u);
		return model;
	}

	public int save(User user) {
		return userDao.save(user);
	}

	public Page<User> queryForUserPage(int pageNo, int pageSize) {
		Page<User> pageUser = new Page<User>();
		pageUser.setPageNo(pageNo);
		pageUser.setPageSize(pageSize);
		
		Integer userTotalCount =userDao.queryUserTotalCount();
		pageUser.setPageTotalCount(userTotalCount);
		Integer pageTotal = userTotalCount / pageSize;
		if(userTotalCount % pageSize > 0) {
			pageTotal = pageTotal + 1;
		}
		pageUser.setPageTotal(pageTotal);
		int begin = (pageUser.getPageNo() - 1) * pageSize;
		List<User> userList = userDao.queryUserPageList(begin,pageSize);
		pageUser.setItems(userList);
		
		return pageUser;
	}

}
