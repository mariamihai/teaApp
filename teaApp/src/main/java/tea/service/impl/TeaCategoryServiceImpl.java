package tea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.TeaCategory;
import tea.dao.repositories.TeaCategoryRepository;
import tea.dto.TeaCategoryDto;
import tea.service.TeaCategoryService;

@Service
@Transactional
public class TeaCategoryServiceImpl implements TeaCategoryService {

	
	@Autowired
	private TeaCategoryRepository repo;
	
	
	public JpaRepository<TeaCategory, Long> getRepo() {
		return repo;
	}


	@Override
	public Long add(TeaCategoryDto dto) throws Exception {
		TeaCategory newCategory = convertToEntity(dto, TeaCategory.class);
		
		TeaCategory savedCategory =  repo.saveAndFlush(newCategory);
		return savedCategory.getId();
	}


	@Override
	public Long update(TeaCategoryDto dto) throws Exception {
		TeaCategory category = repo.findOne(dto.getId());
		category.setName(dto.getName());
		
		TeaCategory savedCategory =  repo.saveAndFlush(category);
		return savedCategory.getId();
	}


	
}
