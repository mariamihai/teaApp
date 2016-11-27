package tea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tea.dao.entities.Flavour;
import tea.dao.repositories.FlavourRepository;
import tea.dto.FlavourDto;
import tea.service.FlavourService;

@Service
@Transactional
public class FlavourServiceImpl implements FlavourService {

	@Autowired
	private FlavourRepository repo;
	
	
	public JpaRepository<Flavour, Long> getRepo() {
		return repo;
	}


	@Override
	public Long add(FlavourDto dto) throws Exception {
		Flavour newFlavour = convertToEntity(dto, Flavour.class);

		Flavour savedFlavour = repo.saveAndFlush(newFlavour);
		return savedFlavour.getId();
	}


	@Override
	public Long update(FlavourDto dto) throws Exception {
		Flavour flavour = repo.findOne(dto.getId());
		flavour.setName(dto.getName());
		
		Flavour savedFlavour = repo.saveAndFlush(flavour);
		return savedFlavour.getId();
	}

}
