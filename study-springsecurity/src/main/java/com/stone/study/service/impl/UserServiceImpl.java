package com.stone.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.stone.study.mapper.UserMapperExt;
import com.stone.study.model.User;
import com.stone.study.model.UserExample;
import com.stone.study.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapperExt userMapper;

	@Override
	public boolean login(String username, String password) throws Exception {
		User user = getUserByName(username);
		if (null != user && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public User getUserByName(String username) {
		if (StringUtils.isNullOrEmpty(username)) {
			return null;
		}
		UserExample userExample = new UserExample();
		UserExample.Criteria userCriteria = userExample.createCriteria();
		userCriteria.andUsernameEqualTo(username);
		List<User> users = userMapper.selectByExample(userExample);
		if (null == users || users.size() < 1) {
			return null;
		}
		return users.get(0);
	}
}