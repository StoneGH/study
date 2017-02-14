package com.stone.study.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.stone.study.model.bo.RoleFuncResource;
import com.stone.study.service.ResourceService;

/**
 * 用来加载资源与权限的全部对应关系的，并提供一个通过资源获取所有权限的方法。
 * 
 * @author Stone+
 * 
 */
@Component("myInvocationSecurityMetadataSource")
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public MyInvocationSecurityMetadataSource() {
	}

	/**
	 * tomcat开启时加载一次，加载所有url和权限（或角色）的对应关系
	 * 
	 * @param resourceService
	 */
	@Autowired
	public MyInvocationSecurityMetadataSource(ResourceService resourceService) {
		loadResourceDefine(resourceService);
	}

	private void loadResourceDefine(ResourceService resourceService) {
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		List<RoleFuncResource> resources = resourceService.getRoleFuncRelation();
		for (RoleFuncResource resource : resources) {
			Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
			ConfigAttribute ca = new SecurityConfig(resource.getRole());
			atts.add(ca);
			resourceMap.put(resource.getUrl(), atts);
		}
	}

	/**
	 * 参数是要访问的url，返回这个url对于的所有权限（或角色）
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String url = ((FilterInvocation) object).getRequestUrl();
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			if (url.indexOf(resURL) != -1) {
				return resourceMap.get(resURL);
			}
		}
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
}
