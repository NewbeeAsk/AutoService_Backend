package com.autoservice.controllers;

import com.autoservice.models.Coordinates;
import com.autoservice.models.Service;
import com.autoservice.repositories.CoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/coordinates")
public class CoordinatesController {

    @Autowired
    private final CoordinatesRepository coordinatesRepository;

    public CoordinatesController(CoordinatesRepository coordinatesRepository) {
        this.coordinatesRepository = coordinatesRepository;
    }

    @GetMapping
    public List<Coordinates> getCoordinates() {
        return coordinatesRepository.findAll();
    }

    @PostMapping
    public Coordinates newCoordinate (@RequestBody Coordinates coordinates) {
        return coordinatesRepository.save(coordinates);
    }

    @DeleteMapping("/{id}")
    public void deleteCoordinate (@PathVariable Integer id) {
        coordinatesRepository.deleteById(id);
    }
}
