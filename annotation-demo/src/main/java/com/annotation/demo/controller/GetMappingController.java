package com.annotation.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: GetMappingController
 * @Author:
 * @Date: 2018/8/3 14:48
 */
@RestController
public class GetMappingController {

    @GetMapping(value = "/getMapping")
    public String sayHello(@RequestParam("id") Integer id) {
        return "id: " + id;
    }

}
