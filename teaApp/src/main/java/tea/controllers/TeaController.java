package tea.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tea.dto.TeaDto;
import tea.exceptions.TeaException;
import tea.service.TeaService;

@RestController
@RequestMapping("/tea")
public class TeaController {

	@Autowired private TeaService service;
	
	
	@GetMapping("/byId/{id}")
	public TeaDto getTea(@PathVariable Long id) {
		try {
			TeaDto dto = service.getDto(id, TeaDto.class);
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@GetMapping("/getAll")
	public List<TeaDto> getAllTeas() {
		try {
			return service.getAllDtos(TeaDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/add")
	public Long addTea(@RequestBody TeaDto dto) {
		try {
			Long id = service.add(dto);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/update")
	public Long updateTea(@RequestBody TeaDto dto) {
		try {
			Long id = service.update(dto);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/delete/{id}") 
	public void deleteTea (@PathVariable Long id){
		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
}
