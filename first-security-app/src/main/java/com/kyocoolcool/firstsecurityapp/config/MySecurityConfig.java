package com.kyocoolcool.firstsecurityapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/18 8:11 PM
 */
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MyAuthenticationProvider authenticationProvider;

// 改由自定義authenticationProvider
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//        UserDetails user = User.withUsername("chris").password(passwordEncoder.encode("chen"))
//                .authorities("reader").build();
//        userDetailsService.createUser(user);
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表單登入
        http.httpBasic();
        //表單登入
//        http.formLogin();
        http.authorizeRequests().antMatchers("/hello").authenticated().anyRequest().denyAll();
        http.addFilterBefore(new MyServletFilter(), BasicAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
