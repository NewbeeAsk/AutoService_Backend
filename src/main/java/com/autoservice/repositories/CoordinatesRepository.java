package com.autoservice.repositories;

import com.autoservice.models.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinatesRepository extends JpaRepository<Coordinates, Object> {
}