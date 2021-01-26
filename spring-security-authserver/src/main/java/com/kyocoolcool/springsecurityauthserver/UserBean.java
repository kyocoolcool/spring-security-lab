package com.kyocoolcool.springsecurityauthserver;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/19 11:34 PM
 */
@Entity
@Table(name = "user", schema = "first_security")
public class UserBean {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<RoleBean> roles;

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
    @Column(name = "first_name", nullable = true, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 20)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 256)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<RoleBean> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleBean> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBean userBean = (UserBean) o;
        return id == userBean.id && Objects.equals(firstName, userBean.firstName) && Objects.equals(lastName, userBean.lastName) && Objects.equals(email, userBean.email) && Objects.equals(password, userBean.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password);
    }
}
