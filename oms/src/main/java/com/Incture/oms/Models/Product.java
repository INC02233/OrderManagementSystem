package com.Incture.oms.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Product {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence" )
	@GenericGenerator(name = "product_sequence", strategy = "com.Incture.oms.Models.ProductIdSequence",parameters = {  
			@Parameter(name = ProductIdSequence.INCREMENT_PARAM, value = "1"),
			@Parameter(name = ProductIdSequence.VALUE_PREFIX_PARAMETER, value = "PRD"),
			@Parameter(name = ProductIdSequence.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	@Id
	private String productId;
	
	private String productName;
	
	private String productDescription;
	
	private boolean productAvailable;
	
	private int rating;
	
	private String price;
	
	private String availableSize;
	
	@JsonIgnore
	@OneToMany(mappedBy = "productID", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Orders> orders = new ArrayList<Orders>();
	
	@ManyToOne
	@JoinColumn(name = "categoryID", referencedColumnName = "categoryId")
	private Category productCategory;
	
	@ManyToOne
	@JoinColumn(name = "supplierID", referencedColumnName = "supplierId")
	private Supplier SupplierInfo;
	
	@JsonIgnore
	@OneToOne(mappedBy = "productID_order")
	private OrderDetails productIdInfo;

	

}
