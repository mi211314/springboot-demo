package com.annotation.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: RequestParamController
 * @Author:
 * @Date: 2018/8/3 14:44
 */
@RestController
public class RequestParamController {

    @RequestMapping(value="/requestParam", method=RequestMethod.GET)
    public String sayHello(@RequestParam("id") Integer id, @RequestParam("name") String name) {
        return "id: " + id + ", name: " + name;
    }

}
