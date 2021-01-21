package com.kyocoolcool.springsecurity.couponservice.controller;

import com.kyocoolcool.springsecurity.couponservice.bean.UserBean;
import com.kyocoolcool.springsecurity.couponservice.repository.UserRepository;
import com.kyocoolcool.springsecurity.couponservice.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/20 11:14 PM
 */
@Controller
public class UserController {
    @Autowired
    private SecurityService securityService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String password) {
        boolean loginResponse = securityService.login(email, password);
        if (loginResponse) {
            return "redirect:index";
        }
        return "login";
    }

    @GetMapping("/showRegistration")
    public String showRegistrationPage() {
        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String register(UserBean userBean) {
        userBean.setPassword(passwordEncoder.encode(userBean.getPassword()));
        userRepository.save(userBean);
        return "login";
    }
}
