package com.kyocoolcool.springsecurity.couponservice.repository;

import com.kyocoolcool.springsecurity.couponservice.bean.CouponBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/19 4:25 PM
 */
public interface CouponRepository extends JpaRepository<CouponBean,Long> {
    CouponBean findByCode(String code);
}
