package com.Incture.oms.Service;

import java.util.List;

import com.Incture.oms.Models.Shippers;

public interface ShipperService {

	public List<Shippers> getShippers();
	public Shippers getShipper(long id);
	public void saveShipper(Shippers shippers);
	public void updateShipper(Shippers shippers, long id);
	public void deleteShipper(long id);
}
