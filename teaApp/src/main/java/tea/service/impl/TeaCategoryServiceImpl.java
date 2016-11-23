package tea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.TeaCategory;
import tea.dao.repositories.TeaCategoryRepository;
import tea.service.TeaCategoryService;

@Service
@Transactional
public class TeaCategoryServiceImpl implements TeaCategoryService {

	@Autowired
	private TeaCategoryRepository repo;
	
	
	public JpaRepository<TeaCategory, Long> getRepo() {
		return repo;
	}

}
