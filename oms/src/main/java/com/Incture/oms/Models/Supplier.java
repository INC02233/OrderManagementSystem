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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_sequence" )
	@GenericGenerator(name = "supplier_sequence", strategy = "com.Incture.oms.Models.SupplierIdSequence",parameters = {  
			@Parameter(name = ProductIdSequence.INCREMENT_PARAM, value = "1"),
			@Parameter(name = ProductIdSequence.VALUE_PREFIX_PARAMETER, value = "SUP"),
			@Parameter(name = ProductIdSequence.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	@Id
	private String supplierId;
	
	private String first_name;
	
	private String last_name;
	
	private String email;
	
	private String companyName;
	
	private String contactNumber;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String country;
	
	@JsonIgnore
	@OneToMany(mappedBy = "SupplierInfo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Product> suppliedProducts = new ArrayList<Product>();

	
	
	
	
}
