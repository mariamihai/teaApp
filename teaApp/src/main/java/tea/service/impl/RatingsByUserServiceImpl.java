package tea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.RatingsByUser;
import tea.dao.repositories.RatingsByUserRepository;
import tea.service.RatingsByUserService;

@Service
@Transactional
public class RatingsByUserServiceImpl implements RatingsByUserService {

	@Autowired
	private RatingsByUserRepository repo;
	
	
	public JpaRepository<RatingsByUser, Long> getRepo() {
		return repo;
	}

}
