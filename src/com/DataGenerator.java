package com;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by weiluo on 2/23/17.
 */
@Component("dataGenerator")
public class DataGenerator {
    @Resource(name = "customer1")
    private Customer customer;
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }




}
