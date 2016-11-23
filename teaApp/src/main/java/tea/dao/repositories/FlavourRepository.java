package tea.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tea.dao.entities.Flavour;

public interface FlavourRepository extends JpaRepository<Flavour, Long> {

}
