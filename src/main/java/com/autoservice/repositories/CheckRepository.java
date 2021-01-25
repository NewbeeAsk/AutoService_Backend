package com.autoservice.repositories;

import com.autoservice.models.Check;
import com.autoservice.models.OrderedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CheckRepository extends JpaRepository<Check, Object> {
    @Query(nativeQuery = true, value = "SELECT * FROM checks WHERE complete = false")
    public List<Check> searchOpenCheck();

    @Query(nativeQuery = true, value = "SELECT * FROM checks WHERE complete = true")
    public List<Check> searchCloseChecks();
}
