package com.properties.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: ProfileController
 * @Author:
 * @Date: 2018/8/3 14:28
 */
@RestController
public class ProfileController {

    @Value("${profile}")
    private String profile;

    @RequestMapping(value="/profile", method=RequestMethod.GET)
    public String sayHello(){
        return profile;
    }

}
