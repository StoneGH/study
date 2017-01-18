package com.stone.study.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public class User implements UserDetails {

	private static final long serialVersionUID = -739110967197874283L;
	private String id;
	private String username;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserInfoVo [username=" + username + ", password=" + password + "]";
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		/**
		 * 测试，写死了角色
		 */
		List<SimpleGrantedAuthority> authos = new ArrayList<SimpleGrantedAuthority>();
		SimpleGrantedAuthority sim = new SimpleGrantedAuthority("ROLE_USER");
		authos.add(sim);
		return authos;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

}
