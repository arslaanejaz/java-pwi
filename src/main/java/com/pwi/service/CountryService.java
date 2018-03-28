package com.pwi.service;

import java.util.List;

import com.pwi.model.Country;


public interface CountryService {

	Country findById(int id);

	Country saveCountry(Country country);
	
	Country updateCountry(int id, Country country);
	
	void deleteCountry(int id);
	
	List<Country> findAllCountrys();


}
