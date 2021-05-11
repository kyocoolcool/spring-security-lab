package com.kyocoolcool.springsecurity.couponservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true,jsr250Enabled = true,securedEnabled = true)
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
////        http.httpBasic();
////        http.formLogin();
////        http.csrf().disable()
        http
                .authorizeRequests()
                .mvcMatchers(HttpMethod.GET,"/couponapi/coupons/{code:^[A-Z0-9]*$}"
                ,"index","showGetCoupon")
                .permitAll()
//                .hasAnyRole("ADMIN","USER")
                .mvcMatchers(HttpMethod.GET, "showCreateCoupon","createCoupon").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST, "/getCoupon").hasAnyRole("ADMIN","USER")
                .mvcMatchers(HttpMethod.POST, "/couponapi/coupons"
                        ,"saveCoupon").hasAnyRole("ADMIN")
                .mvcMatchers("/","/login","showRegistration","registerUser").permitAll()
                .anyRequest().denyAll()
                .and().logout().logoutSuccessUrl("/");
//        http.csrf(csrfCustomizer->{
////            csrfCustomizer.ignoringAntMatchers("/couponapi/coupons/**");
//            RequestMatcher requestMatchers = new RegexRequestMatcher("/couponapi/coupons/^[A-Z0-9]*$", "GET");
////            RequestMatcher requestMatchers =new MvcRequestMatcher(new HandlerMappingIntrospector(), "/getCoupon");
//            csrfCustomizer.ignoringRequestMatchers(requestMatchers);
//        });
//        http.cors(corsCustomizer->{
//            CorsConfigurationSource configurationSource=request->{
//                CorsConfiguration corsConfiguration = new CorsConfiguration();
//                corsConfiguration.setAllowedOrigins(List.of("localhost:3000"));
//                corsConfiguration.setAllowedHeaders(List.of("GET"));
//                return corsConfiguration;
//            };
//            corsCustomizer.configurationSource(configurationSource);});
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
