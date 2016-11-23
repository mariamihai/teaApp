package tea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tea.dto.TeaCategoryDto;
import tea.exceptions.TeaCategoryException;
import tea.service.TeaCategoryService;

@RestController
@RequestMapping("/category")
public class TeaCategoryController {

	@Autowired private TeaCategoryService service;
	
	@GetMapping("/byId/{roleId}")
	public TeaCategoryDto getUserById(@PathVariable Long id) {
		try {
			return service.getDto(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaCategoryException("1");
		}
	}
}
