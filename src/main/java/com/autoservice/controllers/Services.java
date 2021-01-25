package com.autoservice.controllers;

import com.autoservice.models.Check;
import com.autoservice.models.OrderedService;
import com.autoservice.models.Service;
import com.autoservice.repositories.CheckRepository;
import com.autoservice.repositories.OrderedServicesRepository;
import com.autoservice.repositories.ServiceRepository;
import com.autoservice.services.OpenCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auto-service")
public class Services {

    @Autowired
    private final ServiceRepository serviceRepository;

    @Autowired
    private final CheckRepository checkRepository;

    @Autowired
    private final OrderedServicesRepository orderedServicesRepository;

    public Services(ServiceRepository serviceRepository, CheckRepository checkRepository, OrderedServicesRepository orderedServicesRepository) {
        this.serviceRepository = serviceRepository;
        this.checkRepository = checkRepository;
        this.orderedServicesRepository = orderedServicesRepository;
    }

    @CrossOrigin
    @GetMapping
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @CrossOrigin
    @PostMapping
    public Service postNewService(@RequestBody Service service) {
        serviceRepository.save(service);
        return service;
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Integer id) {
        serviceRepository.deleteById(id);
    }

    @CrossOrigin
    @GetMapping("/new-order")
    public OpenCheck openOrder() {
        Check check = checkRepository.save(new Check(BigDecimal.valueOf(0), false));
        List<OrderedService> services = new ArrayList<>();
        return new OpenCheck(services, check);
    }

    @CrossOrigin
    @PostMapping("/order/{id}")
    public OrderedService AddServiceToOrder(@PathVariable Integer id, @RequestBody Service service) {
        Check check = checkRepository.findById(id).orElseThrow();
        OrderedService orderedService = orderedServicesRepository.save(new OrderedService(service.getName(), service.getCategory(), service.getCost(), service.getDescription(), false, check));
        return orderedService;
    }

    @CrossOrigin
    @DeleteMapping("/order/{id}")
    public void deleteServiceFromCart(@PathVariable Integer id) {
        orderedServicesRepository.deleteById(id);
    }

    @CrossOrigin
    @GetMapping("/order")
    public OpenCheck getOpenCheck() {
        Check check;
        if (checkRepository.searchOpenCheck().size() != 0) {
            check = checkRepository.searchOpenCheck().get(0);
        } else {
            check = checkRepository.save(new Check(BigDecimal.valueOf(0), false));
        }
        List<OrderedService> services = orderedServicesRepository.searchOrderedServices(check.getCheck_id());
        return new OpenCheck(services, check);
    }

    @CrossOrigin
    @GetMapping("/order/{id}")
    public Check closeOrder(@PathVariable Integer id) {
        Check check = checkRepository.findById(id).orElseThrow();
        List<OrderedService> services = orderedServicesRepository.searchOrderedServices(check.getCheck_id());
        BigDecimal totalCost = BigDecimal.valueOf(0);
        for (OrderedService service : services) {
            totalCost = totalCost.add(service.getCost());
        }
        check.setTotalCost(totalCost);
        check.setComplete(true);
        checkRepository.save(check);
        return check;
    }

    @CrossOrigin
    @GetMapping("/orders")
    public List<Check> getAllChecks() {
        return checkRepository.searchCloseChecks();
    }
}
