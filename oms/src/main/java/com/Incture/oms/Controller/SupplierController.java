package com.Incture.oms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Incture.oms.Models.Supplier;
import com.Incture.oms.Service.SupplierService;

@RestController
@RequestMapping("/api/v1/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/suppliers")
	public List<Supplier> getSuppliers() {
		return this.supplierService.getSuppliers();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/suppliers/{id}")
	public Supplier getSupplier(@PathVariable String id) {
		return this.supplierService.getSupplier(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String saveSupplier(@RequestBody Supplier supplier) {
		this.supplierService.saveSupplier(supplier);
		return "Supplier created successfully.";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/update")
	public String updateSupplier(@RequestBody Supplier supplier, @PathVariable String id) {
		this.supplierService.updateSupplier(supplier, id);
		return "Supplier updated successfully.";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}/delete")
	public String deleteSupplier(@PathVariable String id) {
		this.supplierService.deleteSupplier(id);
		return "Supplier deleted successfully";
	}
	
}
