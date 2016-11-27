package tea.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.TeaType;
import tea.dao.repositories.TeaCategoryRepository;
import tea.dao.repositories.TeaTypeRepository;
import tea.dto.TeaCategoryDto;
import tea.dto.TeaDto;
import tea.dto.TeaTypeDto;
import tea.service.MapperUtil;
import tea.service.TeaTypeService;

@Service
@Transactional
public class TeaTypeServiceImpl implements TeaTypeService {

	@Autowired private TeaTypeRepository repo;
	@Autowired private TeaCategoryRepository categRepo;
	
	
	public JpaRepository<TeaType, Long> getRepo() {
		return repo;
	}

	@Override
	public Long add(TeaTypeDto dto) throws Exception {
		TeaType newType = convertToEntity(dto, TeaType.class);
		
		TeaType savedType = repo.saveAndFlush(newType);
		return savedType.getId();
	}


	@Override
	public Long update(TeaTypeDto dto) throws Exception {
		TeaType type = repo.findOne(dto.getId());
		type.setName(dto.getName());
		type.setIdCategory(categRepo.findOne(dto.getCategory().getId()));
		
		TeaType savedType = repo.saveAndFlush(type);
		return savedType.getId();
	}
	
	@Override
	public TeaTypeDto convertToDto(TeaType source, Class<TeaTypeDto> targetClass) throws Exception {
	    MapperUtil<TeaTypeDto> typeMapper = new MapperUtil<>();
	    MapperUtil<TeaCategoryDto> categoryMapper = new MapperUtil<>();
	    
	    TeaTypeDto target = (TeaTypeDto) typeMapper.convert(source, targetClass);
	    TeaCategoryDto categoryTarget = (TeaCategoryDto) categoryMapper.convert(source.getIdCategory(), TeaCategoryDto.class);
	    target.setCategory(categoryTarget);
	    
	    return target;
	}
	
	public List<TeaTypeDto> convertToDto(List<TeaType> sources, Class<TeaTypeDto> targetClass) throws Exception {
		List<TeaTypeDto> targets = new ArrayList<TeaTypeDto>();

	    if (sources == null) return null;
		for (Object source : sources) {
		    targets.add(convertToDto((TeaType) source, targetClass));
		}
		
		return targets;
	}
}
