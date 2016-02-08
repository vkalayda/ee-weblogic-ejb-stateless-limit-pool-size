package com.test.prototype;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BillingDelegateBean {

    @EJB
    BillingServer billingServer;

    public String invokeBillingOperation() {
        return billingServer.billingOperation();
    }

}
