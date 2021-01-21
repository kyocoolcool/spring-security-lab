package com.kyocoolcool.springsecurity.couponservice.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/19 4:31 PM
 */
@Entity
@Table(name = "coupon", schema = "first_security")
public class CouponBean {
    private Long id;
    private String code;
    private BigDecimal discount;
    private String expDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code", nullable = true, length = 20)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "discount", nullable = true, precision = 3)
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "exp_date", nullable = true, length = 100)
    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CouponBean that = (CouponBean) o;
        return id == that.id && Objects.equals(code, that.code) && Objects.equals(discount, that.discount) && Objects.equals(expDate, that.expDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, discount, expDate);
    }
}
