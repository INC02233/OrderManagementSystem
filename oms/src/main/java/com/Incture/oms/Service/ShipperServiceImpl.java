package com.Incture.oms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Incture.oms.Models.Shippers;
import com.Incture.oms.dao.ShipperDaoImpl;

@Service
@Transactional
public class ShipperServiceImpl implements ShipperService{

	@Autowired
	private ShipperDaoImpl shipperRepository;
	
	@Override
	public List<Shippers> getShippers() {
		return this.shipperRepository.getShippers();
	}

	@Override
	public Shippers getShipper(long id) {
		return this.shipperRepository.getShipper(id);
	}

	@Override
	public void saveShipper(Shippers shippers) {
		this.shipperRepository.saveShipper(shippers);
	}

	@Override
	public void updateShipper(Shippers shippers, long id) {
		this.shipperRepository.updateShipper(shippers, id);
	}

	@Override
	public void deleteShipper(long id) {
		this.shipperRepository.deleteShipper(id);
	}

}
