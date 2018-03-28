package com.pwi.service;

import java.util.List;

import com.pwi.model.Brand;


public interface BrandService {

	Brand findById(int id);

	Brand saveBrand(Brand brand);
	
	Brand updateBrand(int id, Brand brand);
	
	void deleteBrand(int id);
	
	List<Brand> findAllBrands();


}
