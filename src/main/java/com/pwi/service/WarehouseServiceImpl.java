package com.pwi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwi.dao.WarehouseDao;
import com.pwi.model.Warehouse;

@Service("warehouseService")
@Transactional
public class WarehouseServiceImpl implements WarehouseService {
	
	@Autowired
	private WarehouseDao dao;

	public Warehouse findById(int id) {
		return dao.findById(id);
	}

	public Warehouse saveWarehouse(Warehouse warehouse) {
		return dao.saveWarehouse(warehouse);
		
	}

	public void deleteWarehouse(int id) {
		dao.deleteWarehouse(id);
		
	}

	public List<Warehouse> findAllWarehouses() {
		return dao.findAllWarehouses();
	}

	public Warehouse updateWarehouse(int id, Warehouse warehouse) {
		Warehouse entity = dao.findById(id);
		if(entity!=null){
			entity.setName(warehouse.getName());
		}
		return entity;
		
	}

}
