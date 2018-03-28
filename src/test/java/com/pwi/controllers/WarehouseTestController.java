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

import com.pwi.model.Warehouse;
import com.pwi.service.WarehouseService;
import com.pwi.service.CountryService;
import com.pwi.util.CustomMessage;


public class WarehouseTestController {
	
	@Mock
	WarehouseService service;
	
	@Mock
	CountryService countryService;
	
	@InjectMocks
	WarehouseController warehouseController;
	
	@Spy
    List<Warehouse> warehouse = new ArrayList<Warehouse>();
	
	@BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        warehouse = listWarehouse();
    }
	
	@Test
	public void getListWarehouse() {
		when(service.findAllWarehouses()).thenReturn(warehouse);
		Assert.assertEquals(warehouseController.getList().getBody(), warehouse);
		Assert.assertEquals(warehouseController.getList().getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).findAllWarehouses();
		
	}
	
	@Test
	public void getByIdWarehouse() {
		
		Warehouse obj = warehouse.get(0);
		when(service.findById(1)).thenReturn(obj);
		Assert.assertEquals(warehouseController.getById(1).getBody(), obj);
		Assert.assertEquals(warehouseController.getById(1).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).findById(1);
		
	}
	
	@Test
	public void createWarehouse() {
		
		Warehouse obj = warehouse.get(0);
		when(service.saveWarehouse(obj)).thenReturn(obj);
		Assert.assertEquals(warehouseController.create(1,obj).getBody(), obj);
		Assert.assertEquals(warehouseController.create(1,obj).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).saveWarehouse(obj);
		verify(countryService, atLeastOnce()).findById(1);
		
	}
	
	@Test
	public void updateWarehouse() {
		
		Warehouse obj = warehouse.get(0);
		when(service.updateWarehouse(1, obj)).thenReturn(obj);
		Assert.assertEquals(warehouseController.update(1, obj).getBody(), obj);
		Assert.assertEquals(warehouseController.update(1, obj).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).updateWarehouse(1, obj);
		
	}
	
	@Test
	public void deleteWarehouse() {
		CustomMessage cm = (CustomMessage) warehouseController.delete(1).getBody();
		Assert.assertEquals(cm.getMessage(), "Record Deleted With ID: 1");
		Assert.assertEquals(warehouseController.delete(1).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).deleteWarehouse(1);
		
	}

	
	private List<Warehouse> listWarehouse() {
		Warehouse obj1 = new Warehouse();
		obj1.setId(1);
		obj1.setName("Warehouse1");

		
		Warehouse obj2 = new Warehouse();
		obj2.setId(2);
		obj2.setName("Warehouse2");

		warehouse.add(obj2);
		warehouse.add(obj2);
		return warehouse;
	}

}
