package com.properties.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: HelloController
 * @Author:
 * @Date: 2018/8/3 13:59
 */
@RestController
public class HelloController {

    @Value("${name}")
    private String name;

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String sayHello(){
        return "hello, " + name ;
    }

}
