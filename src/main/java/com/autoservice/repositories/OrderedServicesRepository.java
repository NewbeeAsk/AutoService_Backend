package com.autoservice.repositories;

import com.autoservice.models.OrderedService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedServicesRepository extends JpaRepository<OrderedService, Object> {
}
