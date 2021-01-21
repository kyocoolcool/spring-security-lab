package com.kyocoolcool.firstsecurityapp.config;

import javax.servlet.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/19 11:29 AM
 */
public class MyServletFilter extends GenericFilter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LocalDateTime localDateBefore = LocalDateTime.now();
        System.out.println("before");
        filterChain.doFilter(servletRequest, servletResponse);
        LocalDateTime localDateAfter = LocalDateTime.now();
        System.out.println("after");
        System.out.println(ChronoUnit.MILLIS.between(localDateBefore, localDateAfter) + " Millisecond");
    }
}
