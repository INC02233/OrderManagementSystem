package com.Incture.oms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Incture.oms.Models.Shippers;
import com.Incture.oms.Service.ShipperService;

@RestController
@RequestMapping("/api/v1/shipper")
public class ShipperController {

	@Autowired
	private ShipperService shipperService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/shippers")
	public List<Shippers> getShippers() {
		return this.shipperService.getShippers();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/shippers/{id}")
	public Shippers getShipper(@PathVariable long id) {
		return this.shipperService.getShipper(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String saveShipper(@RequestBody Shippers shippers) {
		this.shipperService.saveShipper(shippers);
		return "Shipper created successfully.";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/update")
	public String updateShipper(@RequestBody Shippers shippers, @PathVariable long id ) {
		this.shipperService.updateShipper(shippers, id);
		return "Shipper updated successfully.";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}/delete")
	public String deleteShipper(long id) {
		this.shipperService.deleteShipper(id);
		return "Shipper deleted successfully.";
	}
	
}
