package com.farmcollector.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.farmcollector.controller.PlantedDataController;
import com.farmcollector.entity.PlantedData;
import com.farmcollector.service.PlantedDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional; 


@WebMvcTest(PlantedDataController.class)
public class PlantedDataControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlantedDataService plantedDataService;

    private ObjectMapper objectMapper = new ObjectMapper();
    
    @Test
    public void testCreatePlantedData() throws Exception {
        PlantedData plantedData = new PlantedData();
        plantedData.setId(1L);

        when(plantedDataService.savePlantedData(plantedData)).thenReturn(plantedData);

        mockMvc.perform(post("/plantedData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(plantedData)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetPlantedDataById() throws Exception {
        Long id = 1L;
        PlantedData plantedData = new PlantedData();
        plantedData.setId(id);

        when(plantedDataService.getPlantedDataById(id)).thenAnswer(invocation->Optional.of(plantedData));

        mockMvc.perform(get("/plantedData/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(plantedData)));
    }

    @Test
    public void testGetPlantedDataByIdNotFound() throws Exception {
        Long id = 1L;

        when(plantedDataService.getPlantedDataById(id)).thenAnswer(invocation->Optional.empty());

        mockMvc.perform(get("/plantedData/{id}", id))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdatePlantedData() throws Exception {
        Long id = 1L;
        PlantedData existingPlantedData = new PlantedData();
        existingPlantedData.setId(id);
        PlantedData updatedPlantedData = new PlantedData();
        updatedPlantedData.setId(id);
        updatedPlantedData.setPlantingArea(100.0);

        when(plantedDataService.updatePlantedData(id, updatedPlantedData)).thenReturn(updatedPlantedData);

        mockMvc.perform(put("/plantedData/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedPlantedData)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(updatedPlantedData)));
    }

    @Test
    public void testDeletePlantedData() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/plantedData/{id}", id))
                .andExpect(status().isNoContent());
    }
}
