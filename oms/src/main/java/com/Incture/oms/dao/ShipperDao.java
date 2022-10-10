package com.Incture.oms.dao;

import java.util.List;

import com.Incture.oms.Models.Shippers;

public interface ShipperDao {

	public List<Shippers> getShippers();
	public Shippers getShipper(long id);
	public void saveShipper(Shippers shippers);
	public void updateShipper(Shippers shippers, long id);
	public void deleteShipper(long id);
}
