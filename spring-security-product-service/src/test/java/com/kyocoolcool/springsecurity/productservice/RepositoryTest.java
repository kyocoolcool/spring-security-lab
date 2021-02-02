package com.kyocoolcool.springsecurity.productservice;

import com.kyocoolcool.springsecurity.productservice.mongo.bean.Boss;
import com.kyocoolcool.springsecurity.productservice.mongo.reposiroty.BossRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/29 4:19 PM
 */


@SpringBootTest
public class RepositoryTest {

    @Autowired
    BossRepository repository;

    Boss dave, oliver, carter;

    @BeforeEach
    public void setUp() {

        repository.deleteAll();

        dave = repository.save(new Boss("Dave", "Matthews"));
        oliver = repository.save(new Boss("Oliver August", "Matthews"));
        carter = repository.save(new Boss("Carter", "Beauford"));
    }

    @Test
    public void setsIdOnSave() {

        Boss dave = repository.save(new Boss("Dave", "Matthews"));

        assertThat(dave.id).isNotNull();
    }

    @Test
    public void findsByLastName() {

        List<Boss> result = repository.findByLastName("Beauford");

        assertThat(result).hasSize(1).extracting("firstName").contains("Carter");
    }

    @Test
    public void findsByExample() {

        Boss probe = new Boss(null, "Matthews");

        List<Boss> result = repository.findAll(Example.of(probe));

        assertThat(result).hasSize(2).extracting("firstName").contains("Dave", "Oliver August");
    }
}
