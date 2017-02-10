package com.stone.study.mapper;

import java.util.List;

import com.stone.study.model.Role;

public interface RoleMapperExt extends RoleMapper {
	/**
	 * 根据用户编号获取用户角色
	 * 
	 * @param uid
	 * @return
	 */
	List<Role> getUserRoles(String uid);
}
