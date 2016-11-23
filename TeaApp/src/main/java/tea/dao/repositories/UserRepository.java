package tea.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tea.dao.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
