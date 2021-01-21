package com.kyocoolcool.springsecurity.couponservice.security;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/20 10:46 PM
 */
public interface SecurityService {
    boolean login(String userName, String password);
}
