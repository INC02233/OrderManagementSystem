package com.Incture.oms.dao;

import java.util.List;

import com.Incture.oms.Models.Supplier;

public interface SupplierDao {

	public List<Supplier> getSuppliers();
	public Supplier getSupplier(String id);
	public void saveSupplier(Supplier supplier);
	public void updateSupplier(Supplier supplier, String id);
	public void deleteSupplier(String id);
}
