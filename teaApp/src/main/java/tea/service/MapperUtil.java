package tea.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class MapperUtil <T> {
		
	public T convert (Object source, Class<T> targetClass) throws Exception {
		if (source == null) return null;
	    
	    T target = targetClass.newInstance();
	    BeanUtils.copyProperties(source, target);
	    
	    return target;
	}
	
	public List<T> convertList (Object sources, Class<T> targetClass) throws Exception {
		List<T> targets = new ArrayList<T>();

	    if (sources == null) return null;
		for (Object source : (List<T>)sources) {
		    targets.add(convert((T) source, targetClass));
		}
		
		return targets;
	}
}
