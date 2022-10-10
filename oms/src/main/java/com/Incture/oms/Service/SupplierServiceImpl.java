package com.Incture.oms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Incture.oms.Models.Supplier;
import com.Incture.oms.dao.SupplierDao;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierDao supplierRepository;

	@Override
	public List<Supplier> getSuppliers() {
		return this.supplierRepository.getSuppliers();
	}

	@Override
	public Supplier getSupplier(String id) {
		return this.supplierRepository.getSupplier(id);
	}

	@Override
	public void saveSupplier(Supplier supplier) {
		this.supplierRepository.saveSupplier(supplier);
	}

	@Override
	public void updateSupplier(Supplier supplier, String id) {
		this.supplierRepository.updateSupplier(supplier, id);
	}

	@Override
	public void deleteSupplier(String id) {
		this.supplierRepository.deleteSupplier(id);
	}
	
	
}
