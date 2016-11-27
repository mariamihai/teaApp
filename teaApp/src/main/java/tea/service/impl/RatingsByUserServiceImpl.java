package tea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.RatingsByUser;
import tea.dao.repositories.RatingsByUserRepository;
import tea.dto.RatingsByUserDto;
import tea.service.RatingsByUserService;

@Service
@Transactional
public class RatingsByUserServiceImpl implements RatingsByUserService {

	@Autowired
	private RatingsByUserRepository repo;
	
	
	public JpaRepository<RatingsByUser, Long> getRepo() {
		return repo;
	}


	@Override
	public Long add(RatingsByUserDto dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Long update(RatingsByUserDto dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
