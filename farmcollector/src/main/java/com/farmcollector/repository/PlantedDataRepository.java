package com.farmcollector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.farmcollector.entity.PlantedData;
import com.farmcollector.entity.Crop;
import com.farmcollector.entity.Season;
import java.util.List;

public interface PlantedDataRepository extends JpaRepository<PlantedData, Long> {

    @Query("SELECT pd FROM PlantedData pd WHERE pd.crop = :crop AND pd.season = :season")
    List<PlantedData> findByCropAndSeason(@Param("crop") Crop crop, @Param("season") Season season);
}
