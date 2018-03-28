package com.pwi.service;

import java.util.List;

import com.pwi.model.Company;


public interface CompanyService {

	Company findById(int id);

	Company saveCompany(Company company);
	
	Company updateCompany(int id, Company company);
	
	void deleteCompany(int id);
	
	List<Company> findAllCompanies();


}
