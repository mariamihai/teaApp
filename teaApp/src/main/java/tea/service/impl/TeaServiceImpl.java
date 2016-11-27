package tea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.Tea;
import tea.dao.repositories.CompanyRepository;
import tea.dao.repositories.TeaRepository;
import tea.dao.repositories.TeaTypeRepository;
import tea.dto.TeaDto;
import tea.service.TeaService;

@Service
@Transactional
public class TeaServiceImpl implements TeaService {

	@Autowired private TeaRepository repo;
	@Autowired private CompanyRepository companyRepo;
	@Autowired private TeaTypeRepository teaTypeRepo;
	
	
	public JpaRepository<Tea, Long> getRepo() {
		return repo;
	}

	@Override
	public Long add(TeaDto dto) throws Exception {
		Tea entity = convertToEntity(dto, Tea.class);
		entity.setCompany(companyRepo.findOne(dto.getCompany().getId()));
		entity.setTeaType(teaTypeRepo.findOne(dto.getTeaType().getId()));
		
		Tea savedTea = repo.saveAndFlush(entity);
		return savedTea.getId();
	}

	@Override
	public Long update(TeaDto dto) throws Exception {
		Tea entity = repo.findOne(dto.getId());
		entity.setHasCaffeine(dto.getHasCaffeine());
		entity.setInfusionTimeS(dto.getInfusionTimeS());
		entity.setName(dto.getName());
		entity.setQuantityQ(dto.getQuantityG());
		entity.setQunatityWaterMl(dto.getQuantityWaterML());
		entity.setTemperatureC(dto.getTemperatureC());
		entity.setTeaType(teaTypeRepo.findOne(dto.getTeaType().getId()));
		entity.setCompany(companyRepo.findOne(dto.getCompany().getId()));
		// TODO - add flavour and ingredients
		
		Tea savedTea = repo.saveAndFlush(entity);
		return savedTea.getId();
	}
}
