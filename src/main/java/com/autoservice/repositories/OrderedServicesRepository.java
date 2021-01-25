package com.autoservice.repositories;

import com.autoservice.models.OrderedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderedServicesRepository extends JpaRepository<OrderedService, Object> {
    @Query(nativeQuery = true, value = "SELECT * FROM ordered_services WHERE check_id = :check_id")
    public List<OrderedService> searchOrderedServices(@Param("check_id") int check_id);
}
