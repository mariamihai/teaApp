package tea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.TeaType;
import tea.dao.repositories.TeaTypeRepository;
import tea.service.TeaTypeService;

@Service
@Transactional
public class TeaTypeServiceImpl implements TeaTypeService {

	@Autowired
	private TeaTypeRepository repo;
	
	
	public JpaRepository<TeaType, Long> getRepo() {
		return repo;
	}

}
