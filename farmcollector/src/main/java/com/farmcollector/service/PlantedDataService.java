package com.farmcollector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farmcollector.entity.PlantedData;
import com.farmcollector.repository.PlantedDataRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PlantedDataService {
	@Autowired
    private PlantedDataRepository plantedDataRepository;

    public PlantedData savePlantedData(PlantedData plantedData) {
        return plantedDataRepository.save(plantedData);
    }

    public List<PlantedData> getAllPlantedData() {
        return plantedDataRepository.findAll();
    }
    
    public Optional<PlantedData> findByFieldId(Long fieldId) {
        // Assuming you have a method in PlantedDataRepository to find by fieldId
        return plantedDataRepository.findById(fieldId);
    }

    public PlantedData updatePlantedData(Long id, PlantedData updatedPlantedData) {
        // Find the existing PlantedData by id
        PlantedData existingPlantedData = plantedDataRepository.findById(id).orElse(null);
        if (existingPlantedData != null) {
        	// Update specific fields
            if (updatedPlantedData.getPlantingArea() != null) {
                existingPlantedData.setPlantingArea(updatedPlantedData.getPlantingArea());
            }
            if (updatedPlantedData.getCrop() != null) {
                existingPlantedData.setCrop(updatedPlantedData.getCrop());
            }
            return plantedDataRepository.save(existingPlantedData);
        } else {
            // Handle not found scenario
            return null; // or throw an exception
        }
    }

    public void deletePlantedData(Long id) {
        plantedDataRepository.deleteById(id);
    }

	public PlantedData getPlantedDataById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
