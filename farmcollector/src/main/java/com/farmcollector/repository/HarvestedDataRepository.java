package com.farmcollector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.farmcollector.entity.HarvestedData;
import java.util.List;

public interface HarvestedDataRepository extends JpaRepository<HarvestedData, Long> {
    @Query("SELECT hd FROM HarvestedData hd WHERE hd.actualProduct > :expectedProduct")
    List<HarvestedData> findHarvestedDataByExceedingExpectedProduct(@Param("expectedProduct") double expectedProduct);
}
