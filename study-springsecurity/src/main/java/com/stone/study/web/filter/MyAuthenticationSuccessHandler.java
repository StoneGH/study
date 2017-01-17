package com.stone.study.web.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.stone.study.model.User;
import com.stone.study.service.UserService;

@Component
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException,
			IOException {
		// 认证成功后，获取用户信息并添加到session中
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		User user = userService.getUserByName(userDetails.getUsername());
		request.getSession().setAttribute("user", user);
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
