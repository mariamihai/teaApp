package tea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.Tea;
import tea.dao.repositories.TeaRepository;
import tea.service.TeaService;

@Service
@Transactional
public class TeaServiceImpl implements TeaService {

	@Autowired
	private TeaRepository repo;
	
	
	public JpaRepository<Tea, Long> getRepo() {
		return repo;
	}

}
