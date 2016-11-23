package tea.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tea.dao.entities.Tea;

public interface TeaRepository extends JpaRepository<Tea, Long> {

}
