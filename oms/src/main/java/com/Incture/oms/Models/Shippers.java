package com.Incture.oms.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shippers")
public class Shippers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shipperId;

	private String companyName;

	private String phone;

	@JsonIgnore
	@OneToMany(mappedBy = "shipperID_fk", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Orders> ordersShipped = new ArrayList<Orders>();

	

}
