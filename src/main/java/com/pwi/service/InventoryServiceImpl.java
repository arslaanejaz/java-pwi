package com.pwi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwi.dao.InventoryDao;
import com.pwi.model.Inventory;

@Service("inventoryService")
@Transactional
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryDao dao;

	public Inventory findById(int id) {
		return dao.findById(id);
	}

	public Inventory saveInventory(Inventory inventory) {
		return dao.saveInventory(inventory);
		
	}

	public void deleteInventory(int id) {
		dao.deleteInventory(id);
		
	}

	public List<Inventory> findAllInventories() {
		return dao.findAllInventories();
	}

	public Inventory updateInventory(int id, Inventory inventory) {
		Inventory entity = dao.findById(id);
		if(entity!=null){
			entity.setItem(inventory.getItem());
			entity.setType(inventory.getType());
			entity.setSize(inventory.getSize());
			entity.setUnit(inventory.getUnit());
			entity.setIn_stock(inventory.getIn_stock());
			entity.setAvl_qty(inventory.getAvl_qty());
			entity.setIn_transit(inventory.getIn_transit());
			entity.setMoq(inventory.getMoq());
			entity.setQpb(inventory.getQpb());
			entity.setReorder_point(inventory.getReorder_point());
		}
		return entity;
		
	}

}
