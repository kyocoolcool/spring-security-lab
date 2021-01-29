package com.kyocoolcool.springsecurity.productservice.config;

import org.springframework.stereotype.Component;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/29 2:01 PM
 */
@Component
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {

    private final Lock lock = new ReentrantLock();

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        lock.lock();
        try {
//            executor.setMaximumPoolSize(executor.getMaximumPoolSize() + 1);
        } finally {
            lock.unlock();
        }

        executor.submit(r);
    }
}
