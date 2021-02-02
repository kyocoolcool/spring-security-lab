package com.kyocoolcool.springsecurity.productservice.mongo.reposiroty;

import com.kyocoolcool.springsecurity.productservice.mongo.bean.Boss;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/29 4:11 PM
 */
public interface BossRepository extends MongoRepository<Boss, String> {

    public Boss findByFirstName(String firstName);

    public List<Boss> findByLastName(String lastName);

}
