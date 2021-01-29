package com.kyocoolcool.springsecurity.productservice.services;

import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/29 10:23 AM
 */
@Service
@Log
public class SendMailService {
    @Async("taskExecutor")
    public void sendMessage1() throws InterruptedException {
        log.info("send mail method---- 1----start");
        Thread.sleep(5000); // 模拟耗时
        log.info("send mail method---- 1----finished");
    }

    @Async("taskExecutor")
    public void sendMessage2() throws InterruptedException {
        log.info("send mail method---- 2----start");
        Thread.sleep(2000);
        log.info("send mail method---- 2----finished");
    }
}
