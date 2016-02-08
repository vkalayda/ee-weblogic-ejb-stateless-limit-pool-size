package com.test.prototype;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
public class TestResource {

    @EJB
    BillingDelegateBean billingDelegate;

    @EJB
    BillingServer billingServer;

    @GET
    @Path("invokeDelegate")
    public String invokeDelegate() {
        return billingDelegate.invokeBillingOperation();
    }

    @GET
    @Path("invokeServer")
    public String invokeServer() {
        return billingServer.billingOperation();
    }

}
