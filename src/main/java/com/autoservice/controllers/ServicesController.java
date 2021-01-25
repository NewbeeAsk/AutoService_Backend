package com.autoservice.controllers;

import com.autoservice.models.Service;
import com.autoservice.repositories.CheckRepository;
import com.autoservice.repositories.OrderedServicesRepository;
import com.autoservice.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/auto-service")
public class ServicesController {

    @Autowired
    private final ServiceRepository serviceRepository;

    public ServicesController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
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

}
