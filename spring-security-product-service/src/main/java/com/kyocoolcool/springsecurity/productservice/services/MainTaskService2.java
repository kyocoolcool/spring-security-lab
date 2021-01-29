package com.kyocoolcool.springsecurity.productservice.services;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/29 10:21 AM
 */
@Service
@Log
public class MainTaskService2 {
    @Qualifier("taskExecutor")
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Async
    @PostConstruct
    public void main2() throws InterruptedException {
//        log.info("main2--start");
//        for (int i = 0; i < 2; i++) {
//            threadPoolTaskExecutor.execute(getTask(i));
//        }
        System.out.println("main2");
    }

    private Runnable getTask(int i) {
        return  () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("running task %d. Thread: %s%n",
                    i,
                    Thread.currentThread().getName());
        };
    }
}
