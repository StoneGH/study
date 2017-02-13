package com.stone.study.web.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 验证资源跟角色之间的关系
 * 
 * @author Stone+
 * 
 */
public class MyAccessDecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,
			InsufficientAuthenticationException {
		if (null == configAttributes) {
			return;
		}
		for (ConfigAttribute attribute : configAttributes) {
			String needRole = ((SecurityConfig) attribute).getAttribute();
			// authority为用户所被赋予的权限, needRole 为访问相应的资源应该具有的权限。
			for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
				if (needRole.equals(grantedAuthority.getAuthority()))
					return;
			}
		}
		throw new AccessDeniedException("权限不足!");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
