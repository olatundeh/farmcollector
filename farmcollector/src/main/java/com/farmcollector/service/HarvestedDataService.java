package com.farmcollector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farmcollector.entity.HarvestedData;
import com.farmcollector.repository.HarvestedDataRepository;
import java.util.List;

@Service
public class HarvestedDataService {

    @Autowired
    private HarvestedDataRepository harvestedDataRepository;

    public HarvestedData saveHarvestedData(HarvestedData harvestedData) {
        return harvestedDataRepository.save(harvestedData);
    }

    public List<HarvestedData> getAllHarvestedData() {
        return harvestedDataRepository.findAll();
    }

    public HarvestedData getHarvestedDataById(Long id) {
        return harvestedDataRepository.findById(id).orElse(null);
    }

    public HarvestedData updateHarvestedData(Long id, HarvestedData updatedHarvestedData) {
        HarvestedData existingHarvestedData = harvestedDataRepository.findById(id).orElse(null);
        if (existingHarvestedData != null) {
            // Update fields
            existingHarvestedData.setActualProduct(updatedHarvestedData.getActualProduct());
            // ... update other fields ...
            return harvestedDataRepository.save(existingHarvestedData);
        } else {
            return null; // Or throw an exception
        }
    }

    public void deleteHarvestedData(Long id) {
        harvestedDataRepository.deleteById(id);
    }
}

