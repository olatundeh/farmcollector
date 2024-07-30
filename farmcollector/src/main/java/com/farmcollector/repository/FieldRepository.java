package com.farmcollector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.farmcollector.entity.Field;
import java.util.List;

public interface FieldRepository extends JpaRepository<Field, Long> {
    @Query("SELECT f FROM Field f WHERE f.size >= :minSize")
    List<Field> findFieldsByMinSize(@Param("minSize") double minSize);
}

