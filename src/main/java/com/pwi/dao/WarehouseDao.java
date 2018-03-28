package com.pwi.dao;

import java.util.List;

import com.pwi.model.Warehouse;


public interface WarehouseDao {

	Warehouse findById(int id);

	Warehouse saveWarehouse(Warehouse warehouse);
	
	void deleteWarehouse(int id);
	
	List<Warehouse> findAllWarehouses();


}
