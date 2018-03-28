package com.pwi.dao;

import java.util.List;

import com.pwi.model.Inventory;


public interface InventoryDao {

	Inventory findById(int id);

	Inventory saveInventory(Inventory inventory);
	
	void deleteInventory(int id);
	
	List<Inventory> findAllInventories();


}
