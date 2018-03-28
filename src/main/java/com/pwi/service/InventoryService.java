package com.pwi.service;

import java.util.List;

import com.pwi.model.Inventory;


public interface InventoryService {

	Inventory findById(int id);

	Inventory saveInventory(Inventory inventory);
	
	Inventory updateInventory(int id, Inventory inventory);
	
	void deleteInventory(int id);
	
	List<Inventory> findAllInventories();


}
