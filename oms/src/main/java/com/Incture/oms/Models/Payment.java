package com.Incture.oms.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentId;
	
	private String paymentType;
	
	private boolean allowed;
	
	@JsonIgnore
	@OneToOne(mappedBy = "paymentID_fk", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Orders paymentIDInfo ;


	
	
}
