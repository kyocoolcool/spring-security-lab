package com.kyocoolcool.springsecurity.couponservice.controller;

import com.kyocoolcool.springsecurity.couponservice.bean.CouponBean;
import com.kyocoolcool.springsecurity.couponservice.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/19 4:35 PM
 */
@RestController
@RequestMapping("/couponapi")
//@CrossOrigin
public class CouponRestController {
    @Autowired
    CouponRepository couponRepository;

    @PostMapping(value = "/coupons")
    public CouponBean create(@RequestBody CouponBean couponBean) {
        return couponRepository.save(couponBean);
    }

    @GetMapping(value = "/coupons/{code}")
    @PostAuthorize("returnObject.discount<60")
    public CouponBean findById(@PathVariable("code") String code) {
        return couponRepository.findByCode(code);
    }

    @GetMapping(value = "/coupons")
    public List<CouponBean> listCoupons() {
        return  couponRepository.findAll();
    }
}
