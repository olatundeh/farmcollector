package com.farmcollector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.farmcollector.entity.Farm;
import java.util.List;

public interface FarmRepository extends JpaRepository<Farm, Long> {
    @Query("SELECT f FROM Farm f WHERE f.name LIKE %:name%")
    List<Farm> findFarmsByNameContaining(@Param("name") String name);
}
