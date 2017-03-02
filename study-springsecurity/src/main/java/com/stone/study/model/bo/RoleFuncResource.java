package com.stone.study.model.bo;

import java.io.Serializable;

public class RoleFuncResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1520607025501606199L;

	/**
	 * 资源路径
	 */
	private String url;

	/**
	 * 资源角色
	 */
	private String role;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
