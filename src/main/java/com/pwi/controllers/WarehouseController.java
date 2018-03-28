package com.pwi.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pwi.exception.CustomErrorType;
import com.pwi.model.Warehouse;
import com.pwi.model.Country;
import com.pwi.service.WarehouseService;
import com.pwi.service.CountryService;
import com.pwi.util.CustomMessage;

 
@RestController
@RequestMapping("/api")
public class WarehouseController {
	
	@Autowired
	private WarehouseService service;
	
	@Autowired
	private CountryService countryService;
	
    //get all
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/warehouses", method = RequestMethod.GET)
    public ResponseEntity<List<Warehouse>> getList() {
    	List<Warehouse> warehouses = service.findAllWarehouses();
    	
    	if (warehouses.isEmpty()) {
    		return (ResponseEntity<List<Warehouse>>) new ResponseEntity(new CustomErrorType("No Data Found For Warehouses"), HttpStatus.NOT_FOUND);
        }
    	return new ResponseEntity<List<Warehouse>>(warehouses ,HttpStatus.OK);
        
    }
    
    //get
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/warehouse/{id}", method = RequestMethod.GET, headers="Accept=application/json")
    @ResponseBody
    public ResponseEntity<Warehouse> getById(@PathVariable(value = "id") Integer id) {
        Warehouse c = service.findById(id);
    	if (c == null) {
    		return new ResponseEntity(new CustomErrorType("Comapny with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Warehouse>(c ,HttpStatus.OK);
    }
    
    
    

    // Create
    @RequestMapping(value = "country/{country_id}/warehouse", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Warehouse> create(@PathVariable(value = "country_id") Integer country_id, @RequestBody Warehouse warehouse) {

    	Country c = countryService.findById(country_id);
    	warehouse.setCountry(c);
        Warehouse b = service.saveWarehouse(warehouse);
        
    	return new ResponseEntity<Warehouse>(b ,HttpStatus.OK);

    }

    // Update
    @RequestMapping(value = "/warehouse/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Warehouse> update(@PathVariable(value = "id") Integer id, @RequestBody Warehouse warehouse) {
    	Warehouse c = service.updateWarehouse(id, warehouse);
    	return new ResponseEntity<Warehouse>(c,HttpStatus.OK);

    }

    // Delete
    @RequestMapping(value = "/warehouse/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id) {
    	service.deleteWarehouse(id);
    	return new ResponseEntity<Object>(new CustomMessage("Record Deleted With ID: "+id),HttpStatus.OK);

    }
}
