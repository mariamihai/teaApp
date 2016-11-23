package tea.service;

import tea.dao.entities.TeaCategory;
import tea.dto.TeaCategoryDto;

public interface TeaCategoryService extends GenericService<TeaCategory, Long>{

	public default TeaCategoryDto getDto(Long id) throws Exception {
		return convertToDto(getRepo().findOne(id), TeaCategoryDto.class);
	}
}
