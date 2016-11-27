package tea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.User;
import tea.dao.repositories.UserRepository;
import tea.dto.CompanyDto;
import tea.dto.UserDto;
import tea.service.MapperUtil;
import tea.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired private UserRepository    repo;
//	@Autowired private CompanyRepository companyRepo;
	
//    MapperUtil<UserDto>    userDtoMapper    = new MapperUtil<>();
//    MapperUtil<User>       userMapper       = new MapperUtil<>();	
    MapperUtil<CompanyDto> companyDtoMapper = new MapperUtil<>();
//    MapperUtil<Company>    companyMapper    = new MapperUtil<>();
	
	
	public JpaRepository<User, Long> getRepo() {
		return repo;
	}

	@Override
	public Long add(UserDto dto) throws Exception {
		User entity = convertToEntity(dto, User.class);
		
		User savedUser = repo.saveAndFlush(entity);
		return savedUser.getId();
	}

	@Override
	public Long update(UserDto dto) throws Exception {
		User entity = repo.findOne(dto.getId());		
		entity.setUsername(dto.getUsername());
		entity.setPassword(dto.getPassword());
		entity.setEmailAddress(dto.getEmailAddress());
		
		User savedUser = repo.saveAndFlush(entity);
		return savedUser.getId();
	}
	
	
	public List<CompanyDto> getCompanies(Long id) throws Exception {
		User entity = repo.findOne(id);
		
		return companyDtoMapper.convertList(entity.getCompanyList(), CompanyDto.class);
	}
}
