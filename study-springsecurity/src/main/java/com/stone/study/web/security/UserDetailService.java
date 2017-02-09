package com.stone.study.web.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.stone.study.mapper.RoleMapperExt;
import com.stone.study.mapper.UserMapperExt;
import com.stone.study.model.Role;
import com.stone.study.model.User;
import com.stone.study.model.UserExample;

@Component
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserMapperExt userMapper;

	@Autowired
	private RoleMapperExt roleMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			// 获取用户信息
			UserExample userExample = new UserExample();
			UserExample.Criteria userCriteria = userExample.createCriteria();
			userCriteria.andUsernameEqualTo(username);
			List<User> users = userMapper.selectByExample(userExample);
			if (null != users && users.size() > 0) {
				User user = users.get(0);

				// 获取用户角色
				List<Role> roles = roleMapper.getUserRoles(user.getId());
				// 设置角色
				return buildUserForAuthentication(user, buildUserAuthority(roles));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new UsernameNotFoundException("User '" + username + "' not found.");
	}

	/**
	 * 验证用户角色
	 * 
	 * @param roles
	 * @return
	 */
	private List<GrantedAuthority> buildUserAuthority(List<Role> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getId().toString()));
		}
		return authorities;
	}

	/**
	 * 返回验证用户
	 * 
	 * @param user
	 * @param authorities
	 * @return
	 */
	private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}
}