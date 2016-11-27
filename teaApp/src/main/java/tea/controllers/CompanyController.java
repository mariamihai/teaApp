package tea.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tea.dto.CompanyDto;
import tea.exceptions.TeaException;
import tea.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired private CompanyService service;
	
	@GetMapping("/byId/{id}")
	public CompanyDto getCompany(@PathVariable Long id) {
		try {
			return service.getDto(id, CompanyDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@GetMapping("/getAll")
	public List<CompanyDto> getAllCompanies() {
		try {
			return service.getAllDtos(CompanyDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/add")
	public Long addCompany(@RequestBody CompanyDto dto) {
		try {
			return service.add(dto);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/update")
	public Long updateCompany(@RequestBody CompanyDto dto) {
		try {
			return service.update(dto);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/delete/{id}")
	public void deleteCompany(@PathVariable Long id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
}
