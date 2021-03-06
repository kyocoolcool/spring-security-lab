package com.kyocoolcool.springsecurity.couponservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/21 5:00 PM
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    private final String RESOURCE_ID = "couponservice";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/couponapi/coupons/{code:^[A-Z0-9]*$}")
                .hasAnyRole("ADMIN", "USER")
                .mvcMatchers(HttpMethod.POST, "/couponapi/coupons").hasAnyRole("ADMIN")
                .anyRequest().denyAll().and().csrf().disable();
    }
}
