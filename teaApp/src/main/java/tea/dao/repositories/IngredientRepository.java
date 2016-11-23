package tea.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tea.dao.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
