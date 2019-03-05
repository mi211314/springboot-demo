package com.springboot.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: IndexController
 * @Author: miaolei
 * @Date: 2019/3/5 23:24
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "hello";
    }

}
