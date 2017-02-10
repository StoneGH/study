package com.stone.study.web.security;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.stone.study.model.Func;
import com.stone.study.model.Role;
import com.stone.study.service.FuncService;
import com.stone.study.service.RoleService;

public class SecurityMetadataSourceExtendImpl implements SecurityMetadataSource {

	private boolean expire = false; // 过期标识

	@Autowired
	private RoleService roleService; // 角色服务类

	@Autowired
	private FuncService funcService; // 资源服务类

	private RequestMatcher requestMatcher; // 匹配规则

	private String matcher; // 规则标识

	private Map<String, Collection<ConfigAttribute>> kv = new HashMap<String, Collection<ConfigAttribute>>(); // 资源集合

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 加载所有资源与权限的关系
	 */
	public void load() {
		List<Func> funcs = this.funcService.queryAll();
		for (Func func : funcs) {
			List<Role> roles = this.roleService.findByResourceId(resource.getId());
			kv.put(func.getName(), list2Collection(roles));
		}
	}

}
