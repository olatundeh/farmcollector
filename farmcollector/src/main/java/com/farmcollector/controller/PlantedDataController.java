package com.farmcollector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.farmcollector.entity.PlantedData; 
import com.farmcollector.service.PlantedDataService;

@RestController
@RequestMapping("/plantedData")
public class PlantedDataController {
	@Autowired
    private PlantedDataService plantedDataService;
	
	
    /**
     * Creates a new planted data record.
     * @param plantedData
     * @return
     */
    @PostMapping
    public ResponseEntity<PlantedData> createPlantedData(@RequestBody PlantedData plantedData) {
        PlantedData createdPlantedData = plantedDataService.savePlantedData(plantedData);
        return new ResponseEntity<>(createdPlantedData, HttpStatus.CREATED);
    }

    /**
     * Retrieves a list of all planted data records.
     * @return
     */
    @GetMapping
    public ResponseEntity<List<PlantedData>> getAllPlantedData() {
        List<PlantedData> plantedData = plantedDataService.getAllPlantedData();
        return ResponseEntity.ok(plantedData);
    }

    /**
     * Retrieves a specific planted data record by ID.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<PlantedData> getPlantedDataById(@PathVariable Long id) {
        PlantedData plantedData = plantedDataService.getPlantedDataById(id); // Assuming a method in service
        if (plantedData != null) {
            return ResponseEntity.ok(plantedData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Updates a specific planted data record by ID.
     * @param id
     * @param updatedPlantedData
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<PlantedData> updatePlantedData(@PathVariable Long id, @RequestBody PlantedData updatedPlantedData) {
        PlantedData updatedData = plantedDataService.updatePlantedData(id, updatedPlantedData);
        if (updatedData != null) {
            return ResponseEntity.ok(updatedData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a specific planted data record by ID.
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlantedData(@PathVariable Long id) {
        plantedDataService.deletePlantedData(id);
        return ResponseEntity.noContent().build();
    }
}
