package com.stone.study.service;

import com.stone.study.model.User;

public interface UserService {
	boolean login(String username, String password) throws Exception;
	User getUserByName(String username);
}
