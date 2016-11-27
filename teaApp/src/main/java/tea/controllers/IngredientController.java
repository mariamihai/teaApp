package tea.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tea.dto.IngredientDto;
import tea.exceptions.TeaException;
import tea.service.IngredientService;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

	@Autowired IngredientService service;
	
	@GetMapping("/byId/{id}")
	public IngredientDto getIngredientById(@PathVariable Long id) {
		try {
			return service.getDto(id, IngredientDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@GetMapping("/getAll")
	public List<IngredientDto> getAllIngredients() {
		try {
			return service.getAllDtos(IngredientDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/add")
	public Long addIngredient(@RequestBody IngredientDto dto) {
		try {
			Long id = service.add(dto);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/update")
	public Long updateIngredient(@RequestBody IngredientDto dto) {
		try {
			Long id = service.update(dto);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/delete/{id}")
	public void deleteIngredient(@PathVariable Long id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
}
