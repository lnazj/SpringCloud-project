package com.dmsdbj.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-08-22
 */
@RestController
@RequestMapping
public class EnvController {

    @Value("${env}")
    private String env;

    @GetMapping("getEnv")
    public String getEnv(){
        return env;
    }
}
