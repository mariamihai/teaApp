package tea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.User;
import tea.dao.repositories.UserRepository;
import tea.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	
	
	public JpaRepository<User, Long> getRepo() {
		return repo;
	}


	@Override
	public Long add(Long dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Long update(Long dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
