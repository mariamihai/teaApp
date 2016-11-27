package tea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.Ingredient;
import tea.dao.repositories.IngredientRepository;
import tea.dto.IngredientDto;
import tea.service.IngredientService;

@Service
@Transactional
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	private IngredientRepository repo;
	
	
	public JpaRepository<Ingredient, Long> getRepo() {
		return repo;
	}

	@Override
	public Long add(IngredientDto dto) throws Exception {
		Ingredient entity = convertToEntity(dto, Ingredient.class);
		
		Ingredient savedEntity = repo.saveAndFlush(entity);
		return savedEntity.getId();
	}


	@Override
	public Long update(IngredientDto dto) throws Exception {
		Ingredient ingredient = repo.findOne(dto.getId());
		ingredient.setName(dto.getName());
		
		Ingredient savedIngredient = repo.saveAndFlush(ingredient);
		return savedIngredient.getId();
	}
}
