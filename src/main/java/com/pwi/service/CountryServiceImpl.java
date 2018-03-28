package com.pwi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwi.dao.CountryDao;
import com.pwi.model.Country;

@Service("countryService")
@Transactional
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryDao dao;

	public Country findById(int id) {
		return dao.findById(id);
	}

	public Country saveCountry(Country country) {
		return dao.saveCountry(country);
		
	}

	public void deleteCountry(int id) {
		dao.deleteCountry(id);
		
	}

	public List<Country> findAllCountrys() {
		return dao.findAllCountries();
	}

	public Country updateCountry(int id, Country country) {
		Country entity = dao.findById(id);
		if(entity!=null){
			entity.setName(country.getName());
		}
		return entity;
		
	}

}
