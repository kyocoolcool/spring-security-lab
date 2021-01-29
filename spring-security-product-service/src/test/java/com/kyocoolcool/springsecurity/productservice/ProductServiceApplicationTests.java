package com.kyocoolcool.springsecurity.productservice;

import com.kyocoolcool.springsecurity.productservice.jpa.bean.AddressBean;
import com.kyocoolcool.springsecurity.productservice.jpa.bean.CustomsBean;
import com.kyocoolcool.springsecurity.productservice.jpa.bean.ProductBean;
import com.kyocoolcool.springsecurity.productservice.jpa.bean.ProductCategoryBean;
import com.kyocoolcool.springsecurity.productservice.jpa.repository.AddressRepository;
import com.kyocoolcool.springsecurity.productservice.jpa.repository.CustomsRepository;
import com.kyocoolcool.springsecurity.productservice.jpa.repository.ProductCategoryRepository;
import com.kyocoolcool.springsecurity.productservice.jpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    CustomsRepository customsRepository;

    @Autowired
    AddressRepository addressRepository;

    @Test
    @Transactional
    void test1() {
        List<ProductBean> all = productRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    void test2() {
        List<ProductCategoryBean> all = productCategoryRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    void test3() {
        ProductBean productBean = new ProductBean();
        productBean.setPrice(new BigDecimal(1000));
        productBean.setDescription("good milk");
        ProductCategoryBean productCategoryBean = new ProductCategoryBean();
        productCategoryBean.setId(17L);
        productBean.setProductCategoryBean(productCategoryBean);
        productRepository.save(productBean);
    }

    @Test
    void testProductCategoryRepository2() {
        ProductCategoryBean productBean = new ProductCategoryBean();
        productBean.setName("milk");
        productCategoryRepository.save(productBean);
    }

    @Test
    void test4() {
        ProductCategoryBean productCategoryBean = new ProductCategoryBean();
        productCategoryBean.setName("ball4");
        ProductBean productBean = new ProductBean();
        productBean.setName("basketball");
        productBean.setPrice(new BigDecimal(100));
        productBean.setDescription("good");
        productCategoryBean.setProducts(List.of(productBean));
        productBean.setProductCategoryBean(productCategoryBean);
        productCategoryRepository.save(productCategoryBean);
    }

    @Test
    @Transactional
    void test5() {
        for (ProductCategoryBean productCategoryBean : productCategoryRepository.findAll()) {
            System.out.println(productCategoryBean.getProducts());
        }
    }

    @Test
    void test6() {
        Optional<ProductCategoryBean> op = productCategoryRepository.findById(1L);
        ProductBean productBean = new ProductBean();
        productBean.setDescription("nice");
        productBean.setPrice(new BigDecimal(1000));
        productBean.setName("coco");
        productBean.setProductCategoryBean(op.get());
        productRepository.save(productBean);
    }

    @Test
    void test7() {
        Optional<ProductCategoryBean> byId = productCategoryRepository.findById(17L);
        productCategoryRepository.delete(byId.get());
    }

    @Test
    void test8() {
        ProductCategoryBean productCategoryBean = new ProductCategoryBean();
        productCategoryBean.setId(16L);
//        productCategoryBean.setName("ball4");
        ProductBean productBean = new ProductBean();
        productBean.setName("basketball");
        productBean.setPrice(new BigDecimal(100));
        productBean.setDescription("good");
        productBean.setProductCategoryBean(productCategoryBean);
        productRepository.save(productBean);
    }

    @Test
    void test9() {
        ProductCategoryBean productCategoryBean = new ProductCategoryBean();
//        Optional<ProductCategoryBean> byId = productCategoryRepository.findById(16L);
//        byId.get().setName("nice eat2");
        ProductCategoryBean productCategoryBean1 = new ProductCategoryBean();
        productCategoryBean1.setName("nice eat3");
        productCategoryRepository.saveAndFlush(productCategoryBean1);
    }

    @Test
    void test10() {
        AddressBean addressBean = new AddressBean();
        addressBean.setAddressName("taipei");
        addressRepository.save(addressBean);
    }

    @Test
    void test11() {
        CustomsBean customsBean = new CustomsBean();
        customsBean.setName("chris");
        customsRepository.save(customsBean);
    }

    @Test
    void test12() {
        CustomsBean customsBean = new CustomsBean();
        customsBean.setName("cat");
        customsRepository.save(customsBean);
    }

    @Test
    void test13() {
        AddressBean addressBean = new AddressBean();
        addressBean.setAddressName("cc");
        CustomsBean customsBean = new CustomsBean();
        customsBean.setName("cc");
        customsBean.setAddressBean(addressBean);
        addressBean.setCustomsBean(customsBean);
        customsRepository.save(customsBean);
    }
}

