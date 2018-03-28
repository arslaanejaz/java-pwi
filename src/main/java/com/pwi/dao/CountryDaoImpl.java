package com.pwi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.pwi.model.Country;

@Repository("countryDao")
public class CountryDaoImpl extends AbstractDao<Integer, Country> implements CountryDao{

	public Country findById(int id) {
		return getByKey(id);
	}

	public Country saveCountry(Country country) {
		persist(country);
		return country;
		
	}

	public void deleteCountry(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	public List<Country> findAllCountries() {
		Criteria criteria = createEntityCriteria();
		return (List<Country>) criteria.list();
	}

}
