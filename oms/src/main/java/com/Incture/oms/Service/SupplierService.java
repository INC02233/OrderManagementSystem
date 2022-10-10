package com.Incture.oms.Service;

import java.util.List;

import com.Incture.oms.Models.Supplier;

public interface SupplierService {

	public List<Supplier> getSuppliers();
	public Supplier getSupplier(String id);
	public void saveSupplier(Supplier supplier);
	public void updateSupplier(Supplier supplier, String id);
	public void deleteSupplier(String id);
}
