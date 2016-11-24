package tea.dao.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import tea.dao.entities.Company;


public interface CompanyRepository extends JpaRepository<Company, Long>{

}
