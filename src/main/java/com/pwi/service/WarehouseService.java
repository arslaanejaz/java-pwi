package com.pwi.service;

import java.util.List;

import com.pwi.model.Warehouse;


public interface WarehouseService {

	Warehouse findById(int id);

	Warehouse saveWarehouse(Warehouse warehouse);
	
	Warehouse updateWarehouse(int id, Warehouse warehouse);
	
	void deleteWarehouse(int id);
	
	List<Warehouse> findAllWarehouses();


}
