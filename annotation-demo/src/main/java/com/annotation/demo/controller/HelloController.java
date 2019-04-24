package com.annotation.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: HelloController
 * @Author:
 * @Date: 2018/8/2 16:38
 */
@Controller
public class HelloController {

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String sayHello() {
        return "hello";
    }

}
