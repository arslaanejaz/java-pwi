package com.pwi.dao;

import java.util.List;

import com.pwi.model.Company;


public interface CompanyDao {

	Company findById(int id);

	Company saveCompany(Company company);
	
	void deleteCompany(int id);
	
	List<Company> findAllCompanies();


}
