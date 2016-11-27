package tea.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tea.dto.FlavourDto;
import tea.exceptions.TeaException;
import tea.service.FlavourService;

@RestController
@RequestMapping("/flavour")
public class FlavourController {

	
	@Autowired private FlavourService service;
	
	@GetMapping("/byId/{id}")
	public FlavourDto getFlavourById (@PathVariable Long id) {
		try {
			FlavourDto flavour = service.getDto(id, FlavourDto.class);
			return flavour;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@GetMapping("/getAll")
	public List<FlavourDto> getAllFlavours () {
		try {
			List<FlavourDto> flavours = service.getAllDtos(FlavourDto.class);
			return flavours;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	
	@PostMapping("/add")
	public Long addFlavour(@RequestBody FlavourDto dto) {
		try {
			Long id = service.add(dto);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/update")
	public Long updateFlavour(@RequestBody FlavourDto dto) {
		try {
			Long id = service.update(dto);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
	@PostMapping("/delete/{id}")
	public void deleteFlavour(@PathVariable Long id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeaException("1");
		}
	}
	
}
