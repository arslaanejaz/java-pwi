package com.pwi.dao;

import java.util.List;

import com.pwi.model.Country;


public interface CountryDao {

	Country findById(int id);

	Country saveCountry(Country country);
	
	void deleteCountry(int id);
	
	List<Country> findAllCountries();


}
