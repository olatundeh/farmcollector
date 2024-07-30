package com.farmcollector.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class PlantedData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Field field;

    @ManyToOne
    private Crop crop;

    @ManyToOne
    private Season season;

    private double plantingArea;
    private double expectedProduct;
    private Date plantingDate;
	public Object getPlantingArea() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setPlantingArea(Object plantingArea2) {
		// TODO Auto-generated method stub
		
	}
	public Object getCrop() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setCrop(Object crop2) {
		// TODO Auto-generated method stub
		
	}
	public void setId(long l) {
		// TODO Auto-generated method stub
		
	}
}
