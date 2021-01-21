package com.autoservice.repositories;

import com.autoservice.models.Check;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckRepository extends JpaRepository<Check, Object> {
}
