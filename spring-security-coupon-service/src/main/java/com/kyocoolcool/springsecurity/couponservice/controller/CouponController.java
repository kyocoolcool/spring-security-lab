package com.kyocoolcool.springsecurity.couponservice.controller;

import com.kyocoolcool.springsecurity.couponservice.bean.CouponBean;
import com.kyocoolcool.springsecurity.couponservice.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/20 4:46 PM
 */
@Controller
public class CouponController {
    @Autowired
    CouponRepository couponRepository;

    @GetMapping("/showCreateCoupon")
    public String showCreateCoupon() {
        return "createCoupon";
    }


    //    @PreAuthorize("hasRole('ADMIN')")
//    @RolesAllowed("ADMIN")
//    @Secured("ADMIN")
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/saveCoupon")
    public String save(CouponBean couponBean) {
        couponRepository.save(couponBean);
        return "createResponse";
    }

    @GetMapping("/showGetCoupon")
    public String showGetCoupon() {
        return "getCoupon";
    }

    @PostMapping("/getCoupon")
    public ModelAndView getCoupon(String code) {
        ModelAndView mav = new ModelAndView("couponDetails");
        mav.addObject(couponRepository.findByCode(code));
        return mav;
    }
}
