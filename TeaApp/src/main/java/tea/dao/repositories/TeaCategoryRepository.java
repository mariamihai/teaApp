package tea.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tea.dao.entities.TeaCategory;

public interface TeaCategoryRepository extends JpaRepository<TeaCategory, Long> {

}
