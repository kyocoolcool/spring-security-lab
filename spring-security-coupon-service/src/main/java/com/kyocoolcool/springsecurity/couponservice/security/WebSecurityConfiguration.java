package com.kyocoolcool.springsecurity.couponservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/20 9:56 AM
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic();
//        http.formLogin();
        http.csrf().disable()
                .authorizeRequests()
                .mvcMatchers(HttpMethod.GET,"/couponapi/coupons/{code:^[A-Z0-9]*$}"
                ,"index","showGetCoupon").hasAnyRole("ADMIN","USER")
                .mvcMatchers(HttpMethod.GET, "showCreateCoupon","createCoupon").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST, "/getCoupon").hasAnyRole("ADMIN","USER")
                .mvcMatchers(HttpMethod.POST, "/couponapi/coupons"
                        ,"saveCoupon").hasAnyRole("ADMIN")
                .mvcMatchers("/","/login","showRegistration","registerUser").permitAll()
                .anyRequest().denyAll()
                .and().logout().logoutSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
