package tea.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.Company;
import tea.dao.entities.User;
import tea.dao.repositories.CompanyRepository;
import tea.dao.repositories.UserRepository;
import tea.dto.CompanyDto;
import tea.dto.UserDto;
import tea.service.CompanyService;
import tea.service.MapperUtil;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired private CompanyRepository repo;
	@Autowired private UserRepository    userRepo;
	
    MapperUtil<CompanyDto> companyDtoMapper = new MapperUtil<>();
    MapperUtil<Company>    companyMapper    = new MapperUtil<>();
    MapperUtil<UserDto>    userDtoMapper    = new MapperUtil<>();
    MapperUtil<User>       userMapper       = new MapperUtil<>();
	
	
	public JpaRepository<Company, Long> getRepo() {
		return repo;
	}

	@Override
	public Long add(CompanyDto dto) throws Exception {
		Company entity = convertToEntity(dto, Company.class);
		
		Company savedEntity = repo.saveAndFlush(entity);
		return savedEntity.getId();
	}


	@Override
	public Long update(CompanyDto dto) throws Exception {
		Company entity = repo.findOne(dto.getId());
		entity.setName(dto.getName());
		entity.setAddedByUser(userRepo.findOne(dto.getAddedByUser().getId()));
		
		Company savedEntity = repo.saveAndFlush(entity);
		return savedEntity.getId();
	}
	

	@Override
	public CompanyDto convertToDto(Company source, Class<CompanyDto> targetClass) throws Exception {
		CompanyDto target = companyDtoMapper.convert(source, targetClass);
		
		UserDto user = userDtoMapper.convert(source.getAddedByUser(), UserDto.class);
		target.setAddedByUser(user);
		
		return target;
	}
	
	@Override
	public List<CompanyDto> convertToDto(List<Company> sources, Class<CompanyDto> targetClass) throws Exception {
		List<CompanyDto> targets = new ArrayList<CompanyDto>();

	    if (sources == null) return null;
		for (Object source : sources) {
		    targets.add(convertToDto((Company) source, targetClass));
		}
		
		return targets;
	}
	
	@Override
	public Company convertToEntity(CompanyDto source, Class<Company> targetClass) throws Exception {
		Company target = companyMapper.convert(source, targetClass);
		
		User user = userMapper.convert(source.getAddedByUser(), User.class);
		target.setAddedByUser(user);

	    // TODO - convert tea list (?)
		
		return target;
	}
}
