package org.jobapp.companyms.company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    void createCompany(Company company);

    boolean updateCompany(Long id, Company updatedCompany);

    boolean deleteCompanyById(Long id);

    Company getCompanyById(Long id);
}
