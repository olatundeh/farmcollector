package com.farmcollector.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.farmcollector.entity.PlantedData;
import com.farmcollector.repository.PlantedDataRepository;
import com.farmcollector.service.PlantedDataService;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlantedDataServiceImplTest {
	@Mock
    private PlantedDataRepository plantedDataRepository;

    @InjectMocks
    private PlantedDataService plantedDataService;

    @Test
    public void testSavePlantedData() {
        PlantedData plantedData = new PlantedData();
        plantedData.setId(1L);

        when(plantedDataRepository.save(plantedData)).thenReturn(plantedData);

        PlantedData result = plantedDataService.savePlantedData(plantedData);

        assertEquals(plantedData, result);
        verify(plantedDataRepository, times(1)).save(plantedData);
    }
}
