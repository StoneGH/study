package com.stone.study.web;

import com.stone.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by shitao on 2018/3/13.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "首页";
    }

    @RequestMapping(value = "/login.html")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }
}
