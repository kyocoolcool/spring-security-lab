package com.kyocoolcool.springsecurity.couponservice.repository;

import com.kyocoolcool.springsecurity.couponservice.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/20 9:51 AM
 */
public interface UserRepository extends JpaRepository<UserBean,Long> {
    UserBean findByEmail(String email);
}
