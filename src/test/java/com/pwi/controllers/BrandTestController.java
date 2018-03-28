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

import com.pwi.model.Brand;
import com.pwi.service.BrandService;
import com.pwi.util.CustomMessage;


public class BrandTestController {
	
	@Mock
	BrandService service;
	
	@InjectMocks
	BrandController brandController;
	
	@Spy
    List<Brand> brand = new ArrayList<Brand>();
	
	@BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        brand = listBrand();
    }
	
	@Test
	public void getListBrand() {
		when(service.findAllBrands()).thenReturn(brand);
		Assert.assertEquals(brandController.getList().getBody(), brand);
		Assert.assertEquals(brandController.getList().getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).findAllBrands();
		
	}
	
	@Test
	public void getByIdBrand() {
		
		Brand obj = brand.get(0);
		when(service.findById(1)).thenReturn(obj);
		Assert.assertEquals(brandController.getById(1).getBody(), obj);
		Assert.assertEquals(brandController.getById(1).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).findById(1);
		
	}
	
	@Test
	public void createBrand() {
		
		Brand obj = brand.get(0);
		when(service.saveBrand(obj)).thenReturn(obj);
		Assert.assertEquals(brandController.create(obj).getBody(), obj);
		Assert.assertEquals(brandController.create(obj).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).saveBrand(obj);
		
	}
	
	@Test
	public void updateBrand() {
		
		Brand obj = brand.get(0);
		when(service.updateBrand(1, obj)).thenReturn(obj);
		Assert.assertEquals(brandController.update(1, obj).getBody(), obj);
		Assert.assertEquals(brandController.update(1, obj).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).updateBrand(1, obj);
		
	}
	
	@Test
	public void deleteBrand() {
		CustomMessage cm = (CustomMessage) brandController.delete(1).getBody();
		Assert.assertEquals(cm.getMessage(), "Record Deleted With ID: 1");
		Assert.assertEquals(brandController.delete(1).getStatusCode(), HttpStatus.OK);
		verify(service, atLeastOnce()).deleteBrand(1);
		
	}

	
	private List<Brand> listBrand() {
		Brand obj1 = new Brand();
		obj1.setId(1);
		obj1.setName("Brand1");

		
		Brand obj2 = new Brand();
		obj2.setId(2);
		obj2.setName("Brand2");

		brand.add(obj2);
		brand.add(obj2);
		return brand;
	}

}
