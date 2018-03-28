package com.pwi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.pwi.model.Company;

@Repository("companyDao")
public class CompanyDaoImpl extends AbstractDao<Integer, Company> implements CompanyDao{

	public Company findById(int id) {
		return getByKey(id);
	}

	public Company saveCompany(Company company) {
		persist(company);
		return company;
		
	}

	public void deleteCompany(int id) {
		delete(getByKey(id));
	}

	@SuppressWarnings("unchecked")
	public List<Company> findAllCompanies() {
		Criteria criteria = createEntityCriteria();
		return (List<Company>) criteria.list();
	}

}
