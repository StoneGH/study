package com.stone.study.mapper;

import java.util.List;

import com.stone.study.model.Role;
import com.stone.study.model.bo.RoleFuncResource;

public interface RoleMapperExt extends RoleMapper {
	/**
	 * 根据用户编号获取用户角色
	 * 
	 * @param uid
	 * @return
	 */
	List<Role> getUserRoles(String uid);

	/**
	 * 获取角色URL资源
	 * 
	 * @return
	 */
	List<RoleFuncResource> getRoleFuncRelation();
}
