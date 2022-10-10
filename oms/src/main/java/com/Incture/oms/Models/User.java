package com.Incture.oms.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
	@GenericGenerator(name = "customer_sequence", strategy = "com.Incture.oms.Models.CustumIDSequence", parameters = {
			@Parameter(name = CustumIDSequence.INCREMENT_PARAM, value = "1"),
			@Parameter(name = CustumIDSequence.VALUE_PREFIX_PARAMETER, value = "KHS"),
			@Parameter(name = CustumIDSequence.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Id
	@Column(name = "userId")
	private String userId;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	private String address;

	private String country;

	private String state;

	private String city;

	private String phone;

	private String houseNo;

	@Column(name = "createdAt")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "IST")
	private Date createdAt;

	@JsonIgnore
	@OneToMany(mappedBy = "orderedBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Orders> orders = new ArrayList<Orders>();

	
	

}
