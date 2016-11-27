package tea.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public interface ConversUtil<Entity, Dto> {
	
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
}
