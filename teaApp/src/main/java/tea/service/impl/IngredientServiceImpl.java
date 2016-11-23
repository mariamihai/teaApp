package tea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.Ingredient;
import tea.dao.repositories.IngredientRepository;
import tea.service.IngredientService;

@Service
@Transactional
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	private IngredientRepository repo;
	
	
	public JpaRepository<Ingredient, Long> getRepo() {
		return repo;
	}

}
