package com.example.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-08-20
 */
@RestController
@RequestMapping("product")
public class ServerController {
    @GetMapping("msg")
    public String msg(){
        System.out.println("wo shi product");
        return "wo shi product-8080";
    }
}
