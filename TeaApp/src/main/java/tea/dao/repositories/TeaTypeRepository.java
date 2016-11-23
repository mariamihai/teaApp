package tea.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tea.dao.entities.TeaType;

public interface TeaTypeRepository extends JpaRepository<TeaType, Long> {

}
