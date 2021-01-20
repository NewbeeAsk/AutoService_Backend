package com.autoservice.controllers;

import com.autoservice.models.Service;
import com.autoservice.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auto-service")
public class servicesController {

    @Autowired
    private final ServiceRepository serviceRepository;

    public servicesController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @CrossOrigin
    @GetMapping("/service")
    public List<Service> getAllServices(){
    return serviceRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/service")
    public Service postNewService(@RequestBody Service service){
    serviceRepository.save(service);
    return service;
    }

    @CrossOrigin
    @DeleteMapping("/service/{id}")
    public void deleteService(@PathVariable Integer id){
    serviceRepository.deleteById(id);
    }

}
