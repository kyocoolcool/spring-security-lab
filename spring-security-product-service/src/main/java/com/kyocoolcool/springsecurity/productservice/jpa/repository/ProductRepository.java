package com.kyocoolcool.springsecurity.productservice.jpa.repository;

import com.kyocoolcool.springsecurity.productservice.jpa.bean.ProductBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/19 5:32 PM
 */
public interface ProductRepository extends JpaRepository<ProductBean, Long> {
}
