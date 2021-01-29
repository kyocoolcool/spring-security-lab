package com.kyocoolcool.springsecurity.productservice.schedule;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/29 11:24 AM
 */
@Configuration
@EnableScheduling
@Log
public class TestSchedule {
    @Scheduled(cron = "${job.schedule}")
    public void scheduleFixedRateTask() {
        log.info("排程開始");
    }
}
