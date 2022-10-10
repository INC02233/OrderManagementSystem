package com.Incture.oms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	private String productId;
	
	private String productName;
	
	private String productDescription;
	
	private boolean productAvailable;
	
	private int rating;
	
	private String price;
	
	private String availableSize;
	
	private String supplierID;
	
	private long categoryID;
	
	
}
