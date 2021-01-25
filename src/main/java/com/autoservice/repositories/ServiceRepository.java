package com.autoservice.repositories;

import com.autoservice.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Object> {
}
