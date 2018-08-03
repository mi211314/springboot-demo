package com.annotation.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: PathVaribaleController
 * @Author: miaolei
 * @Date: 2018/8/3 14:36
 */
@RestController
public class PathVaribaleController {

    @RequestMapping(value="/hello/{id}/{name}", method= RequestMethod.GET)
    public String sayHello(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        return "id: " + id + ", name: " + name;
    }

}
