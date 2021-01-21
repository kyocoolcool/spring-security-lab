package com.kyocoolcool.springsecurity.couponservice.security;

import com.kyocoolcool.springsecurity.couponservice.bean.UserBean;
import com.kyocoolcool.springsecurity.couponservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/20 10:03 AM
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBean userBean = userRepository.findByEmail(username);
        if (userBean == null) {
            throw new UsernameNotFoundException("User not found for email " + username);
        }
        return new User(userBean.getEmail(), userBean.getPassword(), userBean.getRoles());
    }
}
