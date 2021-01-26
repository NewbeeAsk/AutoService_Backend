package com.autoservice.controllers;

import com.autoservice.models.Service;
import com.autoservice.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/auto-service")
public class ServicesController {

    @Autowired
    private final ServiceRepository serviceRepository;

    public ServicesController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @PostMapping
    public Service postNewService(@RequestBody Service service) {
        serviceRepository.save(service);
        return service;
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Integer id) {
        serviceRepository.deleteById(id);
    }

}
