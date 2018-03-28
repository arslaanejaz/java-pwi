package com.pwi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.pwi.model.Inventory;

@Repository("inventoryDao")
public class InventoryDaoImpl extends AbstractDao<Integer, Inventory> implements InventoryDao{

	public Inventory findById(int id) {
		return getByKey(id);
	}

	public Inventory saveInventory(Inventory inventory) {
		persist(inventory);
		return inventory;
		
	}

	public void deleteInventory(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	public List<Inventory> findAllInventories() {
		Criteria criteria = createEntityCriteria();
		return (List<Inventory>) criteria.list();
	}

}
