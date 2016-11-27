package tea.service;

import java.util.List;

import tea.dao.entities.User;
import tea.dto.CompanyDto;
import tea.dto.UserDto;

public interface UserService extends GenericService<User, UserDto>{

	List<CompanyDto> getCompanies(Long id) throws Exception;

}
