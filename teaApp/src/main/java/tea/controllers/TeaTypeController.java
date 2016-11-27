package tea.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tea.dto.TeaTypeDto;
import tea.exceptions.TeaException;
import tea.service.TeaTypeService;

@RestController
@RequestMapping("/type")
public class TeaTypeController {

	
	@Autowired private TeaTypeService service;
	
	@GetMapping("/getAll")
	public List<TeaTypeDto> getAllTypes() {
		try {
			List<TeaTypeDto> types = service.getAllDtos(TeaTypeDto.class);
			return types;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@GetMapping("/byId/{id}")
	public TeaTypeDto getType(@PathVariable Long id) {
		try {
			TeaTypeDto type = service.getDto(id, TeaTypeDto.class);
			return type;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/add")
	public Long addType(@RequestBody TeaTypeDto dto) {
		try {
			Long id = service.add(dto);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	/* Eg.:
	{
	  "id": 2,
	  "name": "Green type 2",
	  "category": {
	    "id": 7
	  }
	} */
	@PostMapping("/update")
	public Long updateType(@RequestBody TeaTypeDto dto) {
		try {
			Long id = service.update(dto);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/delete/{id}")
	public void deleteType(@PathVariable Long id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	
}
