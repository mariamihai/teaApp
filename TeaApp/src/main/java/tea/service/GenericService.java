package tea.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericService<Entity, Dto> {
	
	public JpaRepository<Entity, Long> getRepo();

	public Long add(Dto dto) throws Exception;
	public Long update(Dto dto) throws Exception;
	public default void delete(Long id) throws Exception {
		getRepo().delete(id);
	}
	
	public default Dto getDto(Long id, Class<Dto> targetType) throws Exception {
		Entity entity = getRepo().findOne(id); 
		return convertToDto(entity, targetType);
	}
	public default List<Dto> getAllDtos(Class<Dto> targetType) throws Exception {
		List<Entity> entities = getRepo().findAll();
		return convertToDto(entities, targetType);
	}
	
	
	public default Dto convertToDto(Entity source, Class<Dto> targetType) throws Exception {
	    if (source == null) return null;
	    
	    Dto target = targetType.newInstance();
	    BeanUtils.copyProperties(source, target);
	    
	    
	    return target;
	}
	public default List<Dto> convertToDto(List<Entity> sources, Class<Dto> targetType) throws Exception {
		List<Dto> targets = new ArrayList<Dto>();

	    if (sources == null) return null;
		for (Object source : sources) {		    
		    Dto target = targetType.newInstance();
		    BeanUtils.copyProperties(source, target);
		    targets.add(target);
		}
		
		return targets;
	}
	
	public default Entity convertToEntity(Dto source, Class<Entity> targetType) throws Exception {
	    if (source == null) return null;
	    
	    Entity target = targetType.newInstance();
	    BeanUtils.copyProperties(source, target);
	    
	    return target;
	}
	public default List<Entity> convertToEntity(List<Dto> sources, Class<Entity> targetType) throws Exception {
		List<Entity> targets = new ArrayList<Entity>();

	    if (sources == null) return null;
		for (Object source : sources) {		    
		    Entity target = targetType.newInstance();
		    BeanUtils.copyProperties(source, target);
		    targets.add(target);
		}
		
		return targets;
	}


}
