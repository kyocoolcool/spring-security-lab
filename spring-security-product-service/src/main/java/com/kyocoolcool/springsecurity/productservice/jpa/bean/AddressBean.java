package com.kyocoolcool.springsecurity.productservice.jpa.bean;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/28 8:14 PM
 */
@Entity
@Table(name = "address", schema = "first_security")
public class AddressBean {
    private int id;
    private String addressName;
    private CustomsBean customsBean;

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
    @Column(name = "address_name", nullable = true, length = 100)
    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    public CustomsBean getCustomsBean() {
        return customsBean;
    }

    public void setCustomsBean(CustomsBean customsBean) {
        this.customsBean = customsBean;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBean that = (AddressBean) o;
        return id == that.id && Objects.equals(addressName, that.addressName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addressName);
    }
}
