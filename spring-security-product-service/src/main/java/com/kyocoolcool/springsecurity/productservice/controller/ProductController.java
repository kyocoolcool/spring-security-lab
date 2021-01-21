package com.kyocoolcool.springsecurity.productservice.controller;

import com.kyocoolcool.springsecurity.productservice.bean.ProductBean;
import com.kyocoolcool.springsecurity.productservice.dto.CouponDto;
import com.kyocoolcool.springsecurity.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/19 5:38 PM
 */
@RestController
@RequestMapping("/productapi")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${couponService.url}")
    String couponServiceURL;

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ProductBean create(@RequestBody ProductBean productBean) {
        CouponDto couponDto = restTemplate.getForObject(couponServiceURL + productBean.getCouponCode(), CouponDto.class);
        productBean.setPrice(productBean.getPrice().subtract(couponDto.getDiscount()));
        return productRepository.save(productBean);
    }

}
