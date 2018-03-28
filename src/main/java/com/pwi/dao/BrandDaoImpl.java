package com.pwi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.pwi.model.Brand;

@Repository("brandDao")
public class BrandDaoImpl extends AbstractDao<Integer, Brand> implements BrandDao{

	public Brand findById(int id) {
		return getByKey(id);
	}

	public Brand saveBrand(Brand brand) {
		persist(brand);
		return brand;
		
	}

	public void deleteBrand(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	public List<Brand> findAllBrands() {
		Criteria criteria = createEntityCriteria();
		return (List<Brand>) criteria.list();
	}

}
