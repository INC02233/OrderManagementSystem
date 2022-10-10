package com.Incture.oms.Models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderDetailsId;

	private String price;
	
	private String discount;
	
	private String quantity;
	
	private String size;
	
	private String color;
	
	@Column(name = "shipDate")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
	private Date shipDate;
	
	@Column(name = "billDate")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
	private Date billDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ProductID", referencedColumnName = "productId")
	private Product productID_order;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrderID", referencedColumnName = "orderId")
	private Orders orderID_fk;

	
	
}

