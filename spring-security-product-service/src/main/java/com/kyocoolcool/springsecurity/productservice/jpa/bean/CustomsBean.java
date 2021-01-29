package com.kyocoolcool.springsecurity.productservice.jpa.bean;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/28 8:14 PM
 */
@Entity
@Table(name = "customs", schema = "first_security")
public class CustomsBean {
    private int id;
    private String name;
    private AddressBean addressBean;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(mappedBy = "customsBean", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    public AddressBean getAddressBean() {
        return addressBean;
    }

    public void setAddressBean(AddressBean addressBean) {
        this.addressBean = addressBean;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomsBean that = (CustomsBean) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
