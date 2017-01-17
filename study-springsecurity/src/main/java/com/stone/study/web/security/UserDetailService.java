package com.stone.study.web.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.stone.study.model.User;

public class UserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			User user = new User();
			user.setUsername(username);
			user.setPassword("admin");
			if (null != user) {
				// 设置角色
				return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new UsernameNotFoundException("User '" + username + "' not found.");
	}
}