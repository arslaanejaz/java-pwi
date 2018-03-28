package com.pwi.dao;

import java.util.List;

import com.pwi.model.Brand;


public interface BrandDao {

	Brand findById(int id);

	Brand saveBrand(Brand brand);
	
	void deleteBrand(int id);
	
	List<Brand> findAllBrands();


}
