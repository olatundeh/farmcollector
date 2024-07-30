package com.farmcollector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.farmcollector.entity.Crop;
import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {
    @Query("SELECT c FROM Crop c WHERE c.name LIKE %:name%")
    List<Crop> findCropsByNameContaining(@Param("name") String name);
}