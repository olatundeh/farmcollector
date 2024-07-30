package com.farmcollector.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class HarvestedData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Field field;

    @ManyToOne
    private Crop crop;

    @ManyToOne
    private Season season;

    private double actualProduct;
    private Date harvestDate;
	public Object getActualProduct() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setActualProduct(Object actualProduct2) {
		// TODO Auto-generated method stub
		
	}
}
