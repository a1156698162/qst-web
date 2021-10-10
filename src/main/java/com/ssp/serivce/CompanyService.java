package com.ssp.serivce;

import java.util.List;

import com.ssp.bean.Company;
import com.ssp.bean.MessageModel;
import com.ssp.dao.CompanyDao;

public class CompanyService {
	CompanyDao companyDao = new CompanyDao();

	public int save(Company company) {
		return companyDao.save(company);
	}

	public List<Company> queryAll() {
		return companyDao.queryAll();
	}

	public Company queryById(int id) {
		Company company = null;
		company = companyDao.queryById(id);
		return company;
	}

	public int update(Company company, int id) {
		return companyDao.update(company,id);
	}

	
}
