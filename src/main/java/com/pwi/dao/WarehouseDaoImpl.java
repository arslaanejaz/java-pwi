package com.pwi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.pwi.model.Warehouse;

@Repository("warehouseDao")
public class WarehouseDaoImpl extends AbstractDao<Integer, Warehouse> implements WarehouseDao{

	public Warehouse findById(int id) {
		return getByKey(id);
	}

	public Warehouse saveWarehouse(Warehouse warehouse) {
		persist(warehouse);
		return warehouse;
		
	}

	public void deleteWarehouse(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	public List<Warehouse> findAllWarehouses() {
		Criteria criteria = createEntityCriteria();
		return (List<Warehouse>) criteria.list();
	}

}
