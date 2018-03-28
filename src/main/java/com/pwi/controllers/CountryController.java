package com.pwi.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pwi.exception.CustomErrorType;
import com.pwi.model.Country;
import com.pwi.model.Company;
import com.pwi.service.CountryService;
import com.pwi.service.CompanyService;
import com.pwi.util.CustomMessage;

 
@RestController
@RequestMapping("/api")
public class CountryController {
	
	@Autowired
	private CountryService service;
	
	@Autowired
	private CompanyService comapnyService;
	
    //get all
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
    public ResponseEntity<List<Country>> getList() {
    	List<Country> countrys = service.findAllCountrys();
    	
    	if (countrys.isEmpty()) {
    		return (ResponseEntity<List<Country>>) new ResponseEntity(new CustomErrorType("No Data Found For Countrys"), HttpStatus.NOT_FOUND);
        }
    	return new ResponseEntity<List<Country>>(countrys ,HttpStatus.OK);
        
    }
    
    
    
    //get
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET, headers="Accept=application/json")
    @ResponseBody
    public ResponseEntity<Country> getById(@PathVariable(value = "id") Integer id) {
        Country c = service.findById(id);
    	if (c == null) {
    		return new ResponseEntity(new CustomErrorType("Comapny with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Country>(c ,HttpStatus.OK);
    }
    
    
    

    // Create
    @RequestMapping(value = "company/{company_id}/country", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Country> create(@PathVariable(value = "company_id") Integer company_id, @RequestBody Country country) {

    	Company c = comapnyService.findById(company_id);
    	country.setCompany(c);
        Country b = service.saveCountry(country);
        
    	return new ResponseEntity<Country>(b ,HttpStatus.OK);

    }

    // Update
    @RequestMapping(value = "/country/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Country> update(@PathVariable(value = "id") Integer id, @RequestBody Country country) {
    	Country c = service.updateCountry(id, country);
    	return new ResponseEntity<Country>(c,HttpStatus.OK);

    }

    // Delete
    @RequestMapping(value = "/country/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id) {
    	service.deleteCountry(id);
    	return new ResponseEntity<Object>(new CustomMessage("Record Deleted With ID: "+id),HttpStatus.OK);

    }
}
