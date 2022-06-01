package com.ty.service;

import com.ty.dao.UserDao;
import com.ty.dto.User;

public class UserService {
	UserDao dao = new UserDao();

	public User saveUser(User user) {
		return dao.saveUser(user);
	}
}
