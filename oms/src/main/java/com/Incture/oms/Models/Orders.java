package com.Incture.oms.Models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Orders {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence" )
	@GenericGenerator(name = "order_sequence", strategy = "com.Incture.oms.Models.OrderIdSequence",parameters = {  
			@Parameter(name = ProductIdSequence.INCREMENT_PARAM, value = "1"),
			@Parameter(name = ProductIdSequence.VALUE_PREFIX_PARAMETER, value = "ORD"),
			@Parameter(name = ProductIdSequence.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	@Id
	private String orderId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productID", referencedColumnName = "productId")
	private Product productID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userID", referencedColumnName = "userId")
	private User orderedBy;
	
	@Column(name = "OrderDate")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
	private Date orderedAt;
	
	private String status;
	
	private boolean paid;
	
	@Column(name = "PaymentDate")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
	private Date paymentDate;
	
	@Column(name = "ShippedDate")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
	private Date shippedDate;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ShipperID", referencedColumnName = "shipperId")
	private Shippers shipperID_fk;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "PaymentID", referencedColumnName = "paymentId")
	private Payment paymentID_fk;
	
	@JsonIgnore
	@OneToOne(mappedBy = "orderID_fk")
	private OrderDetails orderIDInfo;

	
	
}
