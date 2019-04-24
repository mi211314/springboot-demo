package com.properties.demo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: Person
 * @Author:
 * @Date: 2018/8/3 14:05
 */
@Component
@ConfigurationProperties(prefix = "person")
@Data
public class Person {

    private String name;

    private Integer age;

}
