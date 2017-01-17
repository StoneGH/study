package com.stone.study.service.impl;

import org.springframework.stereotype.Service;

import com.stone.study.model.User;
import com.stone.study.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Override
	public boolean login(String username, String password) throws Exception {
		if ("admin".equals(username) && "111111".equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public User getUserByName(String username) {
		return new User(username);
	}
}