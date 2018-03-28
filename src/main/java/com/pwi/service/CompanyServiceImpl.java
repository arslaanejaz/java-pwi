package com.pwi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwi.dao.CompanyDao;
import com.pwi.model.Company;

@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDao dao;

	public Company findById(int id) {
		return dao.findById(id);
	}

	public Company saveCompany(Company company) {
		return dao.saveCompany(company);
		
	}

	public void deleteCompany(int id) {
		dao.deleteCompany(id);
		
	}

	public List<Company> findAllCompanies() {
		return dao.findAllCompanies();
	}

	public Company updateCompany(int id, Company company) {
		Company entity = dao.findById(id);
		if(entity!=null){
			entity.setName(company.getName());
		}
		return entity;
		
	}

}
