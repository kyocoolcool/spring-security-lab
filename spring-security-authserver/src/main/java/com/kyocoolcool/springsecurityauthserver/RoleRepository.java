package com.kyocoolcool.springsecurityauthserver;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/20 9:57 AM
 */
public interface RoleRepository extends JpaRepository<RoleBean,Long> {
}
