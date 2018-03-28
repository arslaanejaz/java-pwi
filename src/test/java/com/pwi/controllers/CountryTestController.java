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

import com.pwi.model.Country;
import com.pwi.service.CountryService;
import com.pwi.service.CompanyService;
import com.pwi.util.CustomMessage;


public class CountryTestController {
	
	@Mock
	CountryService service;
	
	@Mock
	CompanyService companyService;
	
	@InjectMocks
	CountryController countryController;
	
	@Spy
    List<Country> country = new ArrayList<Country>();
	
	@BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        country = listCountry();
    }
	
	@Test
	public void getListCountry() {
		when(service.findAllCountrys()).thenReturn(country);
		Assert.assertEquals(countryController.getList().getBody(), country);
		Assert.assertEquals(countryController.getList().getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).findAllCountrys();
		
	}
	
	@Test
	public void getByIdCountry() {
		
		Country obj = country.get(0);
		when(service.findById(1)).thenReturn(obj);
		Assert.assertEquals(countryController.getById(1).getBody(), obj);
		Assert.assertEquals(countryController.getById(1).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).findById(1);
		
	}
	
	@Test
	public void createCountry() {
		
		Country obj = country.get(0);
		when(service.saveCountry(obj)).thenReturn(obj);
		Assert.assertEquals(countryController.create(1,obj).getBody(), obj);
		Assert.assertEquals(countryController.create(1,obj).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).saveCountry(obj);
		verify(companyService, atLeastOnce()).findById(1);
		
	}
	
	@Test
	public void updateCountry() {
		
		Country obj = country.get(0);
		when(service.updateCountry(1, obj)).thenReturn(obj);
		Assert.assertEquals(countryController.update(1, obj).getBody(), obj);
		Assert.assertEquals(countryController.update(1, obj).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).updateCountry(1, obj);
		
	}
	
	@Test
	public void deleteCountry() {
		CustomMessage cm = (CustomMessage) countryController.delete(1).getBody();
		Assert.assertEquals(cm.getMessage(), "Record Deleted With ID: 1");
		Assert.assertEquals(countryController.delete(1).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).deleteCountry(1);
		
	}

	
	private List<Country> listCountry() {
		Country obj1 = new Country();
		obj1.setId(1);
		obj1.setName("Country1");

		
		Country obj2 = new Country();
		obj2.setId(2);
		obj2.setName("Country2");

		country.add(obj2);
		country.add(obj2);
		return country;
	}

}
