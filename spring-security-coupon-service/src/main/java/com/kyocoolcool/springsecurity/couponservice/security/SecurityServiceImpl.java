//package com.kyocoolcool.springsecurity.couponservice.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
///**
// * @author 陳金昌 Chris Chen
// * @version 1.0 2021/1/20 10:47 PM
// */
//@Service
//public class SecurityServiceImpl implements SecurityService{
//
//    @Autowired
//    UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Override
//    public boolean login(String userName, String password) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
//        authenticationManager.authenticate(token);
//        boolean result = token.isAuthenticated();
//        if (result) {
//            SecurityContextHolder.getContext().setAuthentication(token);
//        }
//        return result;
//    }
//}
