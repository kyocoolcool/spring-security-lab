package com.kyocoolcool.firstsecurityapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/18 3:22 PM
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Security";
    }

    @RequestMapping("/bye")
    public String bye() {
        return "Get Lost";
    }
}
