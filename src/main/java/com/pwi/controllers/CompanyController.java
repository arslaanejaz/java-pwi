package com.pwi.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pwi.exception.CustomErrorType;
import com.pwi.model.Company;
import com.pwi.service.CompanyService;
import com.pwi.util.CustomMessage;

 
@RestController
@RequestMapping("/api")
public class CompanyController {
	
	@Autowired
	private CompanyService service;
	
    //get all
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/companies", method = RequestMethod.GET)
    public ResponseEntity<List<Company>> getList() {
    	List<Company> companies = service.findAllCompanies();
    	
    	if (companies.isEmpty()) {
    		return (ResponseEntity<List<Company>>) new ResponseEntity(new CustomErrorType("No Data Found For Companies"), HttpStatus.NOT_FOUND);
        }
    	return new ResponseEntity<List<Company>>(companies ,HttpStatus.OK);
        
    }
    
    
    
    //get
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET, headers="Accept=application/json")
    @ResponseBody
    public ResponseEntity<Company> getById(@PathVariable(value = "id") Integer id) {
        Company c = service.findById(id);
    	if (c == null) {
    		return new ResponseEntity(new CustomErrorType("Comapny with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Company>(c ,HttpStatus.OK);
    }
    
    
    

    // Create
    @RequestMapping(value = "/company", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Company> create(@RequestBody Company company) {
        Company c = service.saveCompany(company);
    	return new ResponseEntity<Company>(c ,HttpStatus.OK);

    }

    // Update
    @RequestMapping(value = "/company/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Company> update(@PathVariable(value = "id") Integer id ,@RequestBody Company company) {
    	Company c = service.updateCompany(id, company);
    	return new ResponseEntity<Company>(c,HttpStatus.OK);

    }

    // Delete
    @RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id) {
    	service.deleteCompany(id);
    	return new ResponseEntity<Object>(new CustomMessage("Record Deleted With ID: "+id),HttpStatus.OK);

    }
}
