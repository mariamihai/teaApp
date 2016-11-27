package tea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.Flavour;
import tea.dao.repositories.FlavourRepository;
import tea.service.FlavourService;

@Service
@Transactional
public class FlavourServiceImpl implements FlavourService {

	@Autowired
	private FlavourRepository repo;
	
	
	public JpaRepository<Flavour, Long> getRepo() {
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
