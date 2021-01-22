package com.autoservice.services;

import com.autoservice.models.Check;
import com.autoservice.models.OrderedService;

import java.util.List;

public class OpenCheck {

    List<OrderedService> orderedServices;
    Check check;

    public OpenCheck(List<OrderedService> orderedServices, Check check) {
        this.orderedServices = orderedServices;
        this.check = check;
    }

    public List<OrderedService> getOrderedServices() {
        return orderedServices;
    }

    public void setOrderedServices(List<OrderedService> orderedServices) {
        this.orderedServices = orderedServices;
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }
}
