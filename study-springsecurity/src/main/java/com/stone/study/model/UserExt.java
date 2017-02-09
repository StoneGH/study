package com.stone.study.model;

import java.util.List;

public class UserExt extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2805416619936372175L;

	/**
	 * 用户角色
	 */
	private List<Role> roles;

	/**
	 * 授权功能
	 */
	private List<Func> funcs;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Func> getFuncs() {
		return funcs;
	}

	public void setFuncs(List<Func> funcs) {
		this.funcs = funcs;
	}

}