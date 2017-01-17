package com.stone.study.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.stone.study.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

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

	@RequestMapping(value = "/login.json", method = RequestMethod.POST)
	@ResponseBody
	public Object loginJson(String username, String password) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password)) {
			resultMap.put("status", -1);
			resultMap.put("message", "用户名和密码不能为空");
			return resultMap;
		}
		try {
			if (userService.login(username, password)) {
				resultMap.put("status", 1);
				resultMap.put("message", "登录成功");
			} else {
				resultMap.put("status", 0);
				resultMap.put("message", "登录失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;

	}
}