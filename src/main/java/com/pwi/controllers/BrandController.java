package com.pwi.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pwi.exception.CustomErrorType;
import com.pwi.model.Brand;
import com.pwi.service.BrandService;
import com.pwi.util.CustomMessage;

 
@RestController
@RequestMapping("/api")
public class BrandController {
	
	@Autowired
	private BrandService service;
	
	
    //get all
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/brands", method = RequestMethod.GET)
    public ResponseEntity<List<Brand>> getList() {
    	List<Brand> brands = service.findAllBrands();
    	
    	if (brands.isEmpty()) {
    		return (ResponseEntity<List<Brand>>) new ResponseEntity(new CustomErrorType("No Data Found For Brands"), HttpStatus.NOT_FOUND);
        }
    	return new ResponseEntity<List<Brand>>(brands ,HttpStatus.OK);
        
    }
    
    
    //get
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/brand/{id}", method = RequestMethod.GET, headers="Accept=application/json")
    @ResponseBody
    public ResponseEntity<Brand> getById(@PathVariable(value = "id") Integer id) {
        Brand c = service.findById(id);
    	if (c == null) {
    		return new ResponseEntity(new CustomErrorType("Comapny with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Brand>(c ,HttpStatus.OK);
    }
    
    
    

    // Create
    @RequestMapping(value = "/brand", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Brand> create(@RequestBody Brand brand) {

        Brand b = service.saveBrand(brand);
        
    	return new ResponseEntity<Brand>(b ,HttpStatus.OK);

    }

    // Update
    @RequestMapping(value = "/brand/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Brand> update(@PathVariable(value = "id") Integer id, @RequestBody Brand brand) {
    	Brand c = service.updateBrand(id, brand);
    	return new ResponseEntity<Brand>(c,HttpStatus.OK);

    }

    // Delete
    @RequestMapping(value = "/brand/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id) {
    	service.deleteBrand(id);
    	return new ResponseEntity<Object>(new CustomMessage("Record Deleted With ID: "+id),HttpStatus.OK);

    }
}
