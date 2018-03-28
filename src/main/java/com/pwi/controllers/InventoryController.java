package com.pwi.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pwi.exception.CustomErrorType;
import com.pwi.model.Inventory;
import com.pwi.model.Warehouse;
import com.pwi.model.Brand;
import com.pwi.service.InventoryService;
import com.pwi.service.WarehouseService;
import com.pwi.service.BrandService;
import com.pwi.util.CustomMessage;

 
@RestController
@RequestMapping("/api")
public class InventoryController {
	
	@Autowired
	private InventoryService service;
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private WarehouseService warehouseService;
	
    //get all
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/inventories", method = RequestMethod.GET)
    public ResponseEntity<List<Inventory>> getList() {
    	List<Inventory> inventorys = service.findAllInventories();
    	
    	if (inventorys.isEmpty()) {
    		return (ResponseEntity<List<Inventory>>) new ResponseEntity(new CustomErrorType("No Data Found For Inventorys"), HttpStatus.NOT_FOUND);
        }
    	return new ResponseEntity<List<Inventory>>(inventorys ,HttpStatus.OK);
        
    }
    
    
    
    //get
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/inventory/{id}", method = RequestMethod.GET, headers="Accept=application/json")
    @ResponseBody
    public ResponseEntity<Inventory> getById(@PathVariable(value = "id") Integer id) {
        Inventory c = service.findById(id);
    	if (c == null) {
    		return new ResponseEntity(new CustomErrorType("Comapny with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Inventory>(c ,HttpStatus.OK);
    }
    
    
    

    // Create
    @RequestMapping(value = "warehouse/{warehouse_id}/brand/{brand_id}/inventory", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Inventory> create(
    		@PathVariable(value = "brand_id") Integer brand_id,
    		@PathVariable(value = "warehouse_id") Integer warehouse_id, 
    		@RequestBody Inventory inventory) {

    	Brand brand = brandService.findById(brand_id);
    	inventory.setBrand(brand);
    	
    	Warehouse warehouse = warehouseService.findById(warehouse_id);
    	inventory.setWarehouse(warehouse);
    	
        Inventory i = service.saveInventory(inventory);
        
    	return new ResponseEntity<Inventory>(i ,HttpStatus.OK);

    }

    // Update
    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Inventory> update(@PathVariable(value = "id") Integer id, @RequestBody Inventory inventory) {
    	Inventory c = service.updateInventory(id, inventory);
    	return new ResponseEntity<Inventory>(c,HttpStatus.OK);

    }

    // Delete
    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id) {
    	service.deleteInventory(id);
    	return new ResponseEntity<Object>(new CustomMessage("Record Deleted With ID: "+id),HttpStatus.OK);

    }
}
