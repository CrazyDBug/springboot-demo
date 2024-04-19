package com.dragon.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2024/4/19 07:13
 * @author: ybl
 */
@RestController
public class UserController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
