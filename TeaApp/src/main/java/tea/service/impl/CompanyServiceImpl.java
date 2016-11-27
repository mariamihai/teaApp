package tea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.Company;
import tea.dao.repositories.CompanyRepository;
import tea.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository repo;
	
	
	public JpaRepository<Company, Long> getRepo() {
		return repo;
	}


	@Override
	public Long add(Long dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Long update(Long dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
