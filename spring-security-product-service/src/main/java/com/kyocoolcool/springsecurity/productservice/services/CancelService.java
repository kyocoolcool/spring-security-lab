package com.kyocoolcool.springsecurity.productservice.services;

import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/29 10:55 AM
 */
@Service
@Log
public class CancelService {
    @Async("taskExecutor")
    public void cancelOrder() throws InterruptedException {
        log.info("cancel order---start");
        Thread.sleep(3000);
        log.info("cancel order---finished");
    }
}
