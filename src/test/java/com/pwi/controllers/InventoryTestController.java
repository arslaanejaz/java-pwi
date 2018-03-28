package com.pwi.controllers;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pwi.model.Inventory;
import com.pwi.service.InventoryService;
import com.pwi.service.WarehouseService;
import com.pwi.service.BrandService;
import com.pwi.util.CustomMessage;


public class InventoryTestController {
	
	@Mock
	InventoryService service;
	
	@Mock
	BrandService brandService;
	
	@Mock
	WarehouseService warehouseService;
	
	@InjectMocks
	InventoryController inventoryController;
	
	@Spy
    List<Inventory> inventory = new ArrayList<Inventory>();
	
	@BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        inventory = listInventory();
    }
	
	@Test
	public void getListInventory() {
		when(service.findAllInventories()).thenReturn(inventory);
		Assert.assertEquals(inventoryController.getList().getBody(), inventory);
		Assert.assertEquals(inventoryController.getList().getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).findAllInventories();
		
	}
	
	@Test
	public void getByIdInventory() {
		
		Inventory obj = inventory.get(0);
		when(service.findById(1)).thenReturn(obj);
		Assert.assertEquals(inventoryController.getById(1).getBody(), obj);
		Assert.assertEquals(inventoryController.getById(1).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).findById(1);
		
	}
	
	@Test
	public void createInventory() {
		
		Inventory obj = inventory.get(0);
		when(service.saveInventory(obj)).thenReturn(obj);
		Assert.assertEquals(inventoryController.create(1,1,obj).getBody(), obj);
		Assert.assertEquals(inventoryController.create(1,1,obj).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).saveInventory(obj);
		verify(brandService, atLeastOnce()).findById(1);
		verify(warehouseService, atLeastOnce()).findById(1);
		
		
	}
	
	@Test
	public void updateInventory() {
		
		Inventory obj = inventory.get(0);
		when(service.updateInventory(1, obj)).thenReturn(obj);
		Assert.assertEquals(inventoryController.update(1, obj).getBody(), obj);
		Assert.assertEquals(inventoryController.update(1, obj).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).updateInventory(1, obj);
		
	}
	
	@Test
	public void deleteInventory() {
		CustomMessage cm = (CustomMessage) inventoryController.delete(1).getBody();
		Assert.assertEquals(cm.getMessage(), "Record Deleted With ID: 1");
		Assert.assertEquals(inventoryController.delete(1).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).deleteInventory(1);
		
	}

	
	private List<Inventory> listInventory() {
		Inventory entity1 = new Inventory();
		entity1.setItem("item1");
		entity1.setType("Finished Product");
		entity1.setSize(10);
		entity1.setUnit("kg");
		entity1.setIn_stock(20);
		entity1.setAvl_qty(9);
		entity1.setIn_transit(6);
		entity1.setMoq(10);
		entity1.setQpb(1);
		entity1.setReorder_point(30);

		
		Inventory entity2 = new Inventory();
		entity2.setItem("item1");
		entity2.setType("Component");
		entity2.setSize(10);
		entity2.setUnit("small");
		entity2.setIn_stock(30);
		entity2.setAvl_qty(9);
		entity2.setIn_transit(6);
		entity2.setMoq(10);
		entity2.setQpb(1);
		entity2.setReorder_point(30);

		inventory.add(entity1);
		inventory.add(entity2);
		return inventory;
	}

}
