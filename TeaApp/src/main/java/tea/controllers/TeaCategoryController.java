package tea.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tea.dto.TeaCategoryDto;
import tea.exceptions.TeaCategoryException;
import tea.service.TeaCategoryService;

@RestController
@RequestMapping("/category")
public class TeaCategoryController {

	@Autowired private TeaCategoryService service;

	@GetMapping("/getAll")
	public List<TeaCategoryDto> getAllCategories() {
		try {
			List<TeaCategoryDto> categories = service.getAllDtos(TeaCategoryDto.class);
			return categories;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaCategoryException("1");
		}
	}
	
	@GetMapping("/byId/{id}")
	public TeaCategoryDto getCategoryById(@PathVariable Long id) {
		try {
			TeaCategoryDto category = service.getDto(id, TeaCategoryDto.class);
			return category;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaCategoryException("1");
		}
	}
	
	@PostMapping("/add")
	public Long addCategory(@RequestBody TeaCategoryDto dto) {
		try {
			Long id = service.add(dto);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaCategoryException("1");
		}
	}

	@PostMapping("/update")
	public Long updateCategory(@RequestBody TeaCategoryDto dto) {
		try {
			Long id = service.update(dto);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaCategoryException("1");
		}
	}
	
	@GetMapping("/delete/{id}")
	public void udeleteCategory(@PathVariable Long id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaCategoryException("1");
		}
	}
}
