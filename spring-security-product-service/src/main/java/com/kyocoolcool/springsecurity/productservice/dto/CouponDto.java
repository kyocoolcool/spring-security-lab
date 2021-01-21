package com.kyocoolcool.springsecurity.productservice.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/19 6:21 PM
 */
@Data
public class CouponDto {
    private Long id;
    private String code;
    private BigDecimal discount;
    private String expDate;
}
