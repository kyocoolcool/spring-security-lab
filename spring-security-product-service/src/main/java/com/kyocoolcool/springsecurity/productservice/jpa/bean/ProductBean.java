package com.kyocoolcool.springsecurity.productservice.jpa.bean;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/19 5:30 PM
 */
@Entity
@Table(name = "product", schema = "first_security")
public class ProductBean {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String couponCode;
    private ProductCategoryBean productCategoryBean;

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

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id",insertable = true,updatable = true,referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public ProductCategoryBean getProductCategoryBean() {
        return productCategoryBean;
    }

    public void setProductCategoryBean(ProductCategoryBean productCategoryBean) {
        this.productCategoryBean = productCategoryBean;
    }

    @Transient
    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        couponCode = couponCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBean that = (ProductBean) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    @Override
    public String toString() {
        return "ProductBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", couponCode='" + couponCode + '\'' +
                ", productCategoryBean=" + productCategoryBean +
                '}';
    }
}
