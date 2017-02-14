package com.stone.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.study.mapper.RoleMapperExt;
import com.stone.study.model.bo.RoleFuncResource;
import com.stone.study.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private RoleMapperExt roleMapper;

	@Override
	public List<RoleFuncResource> getRoleFuncRelation() {
		return roleMapper.getRoleFuncRelation();
	}

}
