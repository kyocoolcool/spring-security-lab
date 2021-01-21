package com.kyocoolcool.firstsecurityapp.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/19 10:29 AM
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        if ("chris".equals(userName) && "chen".equals(password)) {
            return new UsernamePasswordAuthenticationToken(userName, password, Arrays.asList());
        } else {
            throw new BadCredentialsException("Invalid Username or Password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
