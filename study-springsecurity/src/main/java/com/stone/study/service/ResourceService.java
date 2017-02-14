package com.stone.study.service;

import java.util.List;

import com.stone.study.model.bo.RoleFuncResource;

/**
 * 系统资源
 * 
 * @author Stone
 * 
 */
public interface ResourceService {

	/**
	 * 获得用户权限角色关系
	 * 
	 * @return
	 */
	List<RoleFuncResource> getRoleFuncRelation();
}
