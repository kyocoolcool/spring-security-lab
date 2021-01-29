package com.kyocoolcool.springsecurity.productservice.jpa.bean;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/28 2:24 PM
 */
@Entity
@Table(name = "product_category", schema = "first_security")
public class ProductCategoryBean {
    private Long id;
    private String name;
    private List<ProductBean> products;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "productCategoryBean", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @OneToMany(mappedBy = "productCategoryBean", cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    public List<ProductBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductBean> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategoryBean that = (ProductCategoryBean) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ProductCategoryBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
