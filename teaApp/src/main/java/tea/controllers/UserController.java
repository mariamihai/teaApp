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
import tea.dto.UserDto;
import tea.exceptions.TeaException;
import tea.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired private UserService service;
	
	
	@GetMapping("/byId/{id}")
	public UserDto getUser(@PathVariable Long id) {
		try {
			UserDto dto = service.getDto(id, UserDto.class);
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@GetMapping("/getAll")
	public List<UserDto> getAllUsers() {
		try {
			return service.getAllDtos(UserDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/add")
	public Long addUser(@RequestBody UserDto dto) {
		try {
			Long id = service.add(dto);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/update")
	public Long updateUser(@RequestBody UserDto dto) {
		try {
			Long id = service.update(dto);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/delete/{id}") 
	public void deleteUser (@PathVariable Long id){
		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@GetMapping("/getCompaniesByUser/{id}")
	public List<CompanyDto> getCompaniesByUser(@PathVariable Long id) {
		try {
			return service.getCompanies(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
}
