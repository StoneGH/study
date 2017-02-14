package com.stone.study.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.stone.study.model.User;
import com.stone.study.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager myAuthenticationManager;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mv = new ModelAndView("login");
		return mv;

	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	@RequestMapping(value = "/loginjson", method = RequestMethod.POST)
	@ResponseBody
	public Object loginJson(String username, String password, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password)) {
			resultMap.put("status", -1);
			resultMap.put("message", "用户名和密码不能为空");
			return resultMap;
		}
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
			Authentication authentication = myAuthenticationManager.authenticate(authenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			HttpSession session = request.getSession();
			session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());// 这个非常重要，否则验证后将无法登陆
			// if (userService.login(user.getUsername(), user.getPassword())) {
			// resultMap.put("status", 1);
			// resultMap.put("message", "登录成功");
			// } else {
			// resultMap.put("status", 0);
			// resultMap.put("message", "登录失败");
			// }
			resultMap.put("status", 1);
			resultMap.put("msg", "登录成功！");
		} catch (AuthenticationException ex) {
			resultMap.put("status", 0);
			resultMap.put("msg", "用户名和密码错误！");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("status", 0);
			resultMap.put("msg", "服务器错误！");
		}
		return resultMap;

	}
}