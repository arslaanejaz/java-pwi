package com.pwi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwi.dao.BrandDao;
import com.pwi.model.Brand;

@Service("brandService")
@Transactional
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandDao dao;

	public Brand findById(int id) {
		return dao.findById(id);
	}

	public Brand saveBrand(Brand brand) {
		return dao.saveBrand(brand);
		
	}

	public void deleteBrand(int id) {
		dao.deleteBrand(id);
		
	}

	public List<Brand> findAllBrands() {
		return dao.findAllBrands();
	}

	public Brand updateBrand(int id, Brand brand) {
		Brand entity = dao.findById(id);
		if(entity!=null){
			entity.setName(brand.getName());
		}
		return entity;
		
	}

}
