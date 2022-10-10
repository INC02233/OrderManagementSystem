package com.Incture.oms.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

	private String orderId;
	private Date orderedAt;
	private String status;
	private boolean paid;
	private Date paymentDate;
	private Date shippedDate;
	
	
	private long shipperID;
	private String userID;
	private long paymentID;
	private String productID;
	
}
