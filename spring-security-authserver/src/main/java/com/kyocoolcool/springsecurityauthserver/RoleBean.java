package com.kyocoolcool.springsecurityauthserver;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/19 11:34 PM
 */
@Entity
@Table(name = "role", schema = "first_security")
public class RoleBean implements GrantedAuthority {
    private Long id;
    private String name;
    private Set<UserBean> users;

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
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<UserBean> getUsers() {
        return users;
    }

    public void setUsers(Set<UserBean> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleBean roleBean = (RoleBean) o;
        return Objects.equals(id, roleBean.id) && Objects.equals(name, roleBean.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Transient
    @Override
    public String getAuthority() {
        return name;
    }
}
