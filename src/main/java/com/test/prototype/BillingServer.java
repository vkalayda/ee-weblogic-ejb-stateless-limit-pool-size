package com.test.prototype;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class BillingServer {

    private static final int MAX_CONCURRENT_CLIENTS = 4;

    private final AtomicInteger counter = new AtomicInteger();

    public String billingOperation() {
        try {
            int current = counter.incrementAndGet();

            // Overflow detection
            if (current > MAX_CONCURRENT_CLIENTS) {
                System.out.println("OVERFLOW");
            }

            // Some server side long time operation
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException ex) {
            }

            return "OK";
        } finally {
            counter.decrementAndGet();
        }
    }

}
