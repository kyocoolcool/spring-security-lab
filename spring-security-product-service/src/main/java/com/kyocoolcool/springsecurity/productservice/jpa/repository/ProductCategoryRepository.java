package com.kyocoolcool.springsecurity.productservice.jpa.repository;

import com.kyocoolcool.springsecurity.productservice.jpa.bean.ProductCategoryBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/28 2:41 PM
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryBean, Long> {
}
