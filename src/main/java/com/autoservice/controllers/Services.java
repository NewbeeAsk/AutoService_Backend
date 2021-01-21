package com.autoservice.controllers;

import com.autoservice.models.Check;
import com.autoservice.models.OrderedService;
import com.autoservice.models.Service;
import com.autoservice.repositories.CheckRepository;
import com.autoservice.repositories.OrderedServicesRepository;
import com.autoservice.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Service> getAllServices(){
    return serviceRepository.findAll();
    }

    @CrossOrigin
    @PostMapping
    public Service postNewService(@RequestBody Service service){
    serviceRepository.save(service);
    return service;
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Integer id){
    serviceRepository.deleteById(id);
    }

}
