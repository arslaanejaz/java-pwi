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

import com.pwi.model.Company;
import com.pwi.service.CompanyService;
import com.pwi.util.CustomMessage;


public class CompanyTestController {
	
	@Mock
	CompanyService service;
	
	@InjectMocks
	CompanyController companyController;
	
	@Spy
    List<Company> company = new ArrayList<Company>();
	
	@BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        company = listCompany();
    }
	
	@Test
	public void getListCompany() {
		when(service.findAllCompanies()).thenReturn(company);
		Assert.assertEquals(companyController.getList().getBody(), company);
		Assert.assertEquals(companyController.getList().getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).findAllCompanies();
		
	}
	@Test
	public void getByIdCompany() {
		
		Company c1 = company.get(0);
		when(service.findById(1)).thenReturn(c1);
		Assert.assertEquals(companyController.getById(1).getBody(), c1);
		Assert.assertEquals(companyController.getById(1).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).findById(1);
		
	}
	
	@Test
	public void createCompany() {
		
		Company c1 = company.get(0);
		when(service.saveCompany(c1)).thenReturn(c1);
		Assert.assertEquals(companyController.create(c1).getBody(), c1);
		Assert.assertEquals(companyController.create(c1).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).saveCompany(c1);
		
	}
	
	@Test
	public void updateCompany() {
		
		Company c1 = company.get(0);
		when(service.updateCompany(1, c1)).thenReturn(c1);
		Assert.assertEquals(companyController.update(1, c1).getBody(), c1);
		Assert.assertEquals(companyController.update(1, c1).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).updateCompany(1, c1);
		
	}
	
	@Test
	public void deleteCompany() {
		CustomMessage cm = (CustomMessage) companyController.delete(1).getBody();
		Assert.assertEquals(cm.getMessage(), "Record Deleted With ID: 1");
		Assert.assertEquals(companyController.delete(1).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).deleteCompany(1);
		
	}

	
	private List<Company> listCompany() {
		Company c1 = new Company();
		c1.setId(1);
		c1.setName("A");
		
		Company c2 = new Company();
		c2.setId(2);
		c2.setName("B");

		company.add(c1);
		company.add(c2);
		return company;
	}

}
