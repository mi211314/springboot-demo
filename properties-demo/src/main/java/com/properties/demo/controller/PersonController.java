package com.properties.demo.controller;

import com.properties.demo.configuration.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: PersonController
 * @Author: miaolei
 * @Date: 2018/8/3 14:07
 */
@RestController
public class PersonController {

    @Autowired
    private Person person;

    @RequestMapping(value="/person", method=RequestMethod.GET)
    public String sayHello(){
        return "hello, " + person.getName();
    }

}
