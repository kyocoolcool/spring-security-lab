package com.kyocoolcool.springsecurity.productservice.services;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/29 10:21 AM
 */
@Service
@Log
public class MainTaskService {
    @Autowired
    private SendMailService sendMailService;
    @Autowired
    CancelService cancelService;

    @Async
    @PostConstruct
    public void main1() throws InterruptedException {
        log.info("main1--start");
        cancelService.cancelOrder();
        sendMailService.sendMessage1();
        sendMailService.sendMessage2();
        Thread.sleep(5000);
        log.info("main1--finished");
    }

//    @Async
//    @PostConstruct
//    public void main2() throws InterruptedException {
//        log.info("main2--start");
//    }
}
