package com.stone.sbmc.web.controller;

import com.stone.sbmc.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: TestController
 * @Desc: TODO
 * @Auther: shitao
 * @Date: 2020/09/24 09:24
 * @Version: 1.0
 * @Modified By:
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestServiceImpl testService;

    @RequestMapping("/query")
    @ResponseBody
    public Object query() {
        System.out.println("-------------------");
        return this.testService.query();
    }
}
