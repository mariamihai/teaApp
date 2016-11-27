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
}
