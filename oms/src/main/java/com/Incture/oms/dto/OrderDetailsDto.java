package com.Incture.oms.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDto {

	private long orderDetailsId;
	private String price;
	private String discount;
	private String quantity;
	private String size;
	private String color;
	private Date shipDate;
	private Date billDate;
	
	private String productID;
	private String orderID;
}
