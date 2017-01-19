package com.stone.study.web.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.stone.study.mapper.UserMapperExt;
import com.stone.study.model.User;
import com.stone.study.model.UserExample;

@Component
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserMapperExt userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserExample userExample = new UserExample();
			UserExample.Criteria userCriteria = userExample.createCriteria();
			userCriteria.andUsernameEqualTo(username);
			List<User> users = userMapper.selectByExample(userExample);
			if (null != users && users.size() > 0) {
				User user = users.get(0);
				// 设置角色
				return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
						AuthorityUtils.createAuthorityList("ROLE_USER"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new UsernameNotFoundException("User '" + username + "' not found.");
	}
}