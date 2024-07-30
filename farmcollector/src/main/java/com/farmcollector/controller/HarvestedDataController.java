package com.farmcollector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.farmcollector.entity.HarvestedData;
import com.farmcollector.service.HarvestedDataService;

@RestController
@RequestMapping("/harvestedData")
public class HarvestedDataController {

    @Autowired
    private HarvestedDataService harvestedDataService;

    @PostMapping
    public ResponseEntity<HarvestedData> createHarvestedData(@RequestBody HarvestedData harvestedData) {
        HarvestedData createdHarvestedData = harvestedDataService.saveHarvestedData(harvestedData);
        return new ResponseEntity<>(createdHarvestedData, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HarvestedData>> getAllHarvestedData() {
        List<HarvestedData> harvestedData = harvestedDataService.getAllHarvestedData();
        return ResponseEntity.ok(harvestedData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HarvestedData> getHarvestedDataById(@PathVariable Long id) {
        HarvestedData harvestedData = harvestedDataService.getHarvestedDataById(id);
        if (harvestedData != null) {
            return ResponseEntity.ok(harvestedData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HarvestedData> updateHarvestedData(@PathVariable Long id, @RequestBody HarvestedData updatedHarvestedData) {
        HarvestedData updatedData = harvestedDataService.updateHarvestedData(id, updatedHarvestedData);
        if (updatedData != null) {
            return ResponseEntity.ok(updatedData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHarvestedData(@PathVariable Long id) {
        harvestedDataService.deleteHarvestedData(id);
        return ResponseEntity.noContent().build();
    }
}

