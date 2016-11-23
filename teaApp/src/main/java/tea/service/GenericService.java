package tea.service;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericService<Entity, Dto> {
	
	public JpaRepository<Entity, Long> getRepo();
		
	public default <Dto> Dto convertToDto(Object source, Class<Dto> targetType) throws Exception {
	    if (source == null) return null;
	    
	    Dto target = targetType.newInstance();
	    BeanUtils.copyProperties(source, target);
	    return target;
	}
	
}
