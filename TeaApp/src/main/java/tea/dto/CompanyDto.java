package tea.dto;

import java.util.List;

public class CompanyDto {
	
	
	private Long id;
    private String name;
    private List<TeaDto> teaList;
    private UserDto addedByUser;
    

	public CompanyDto() { super(); }
	public CompanyDto(Long id) {
		super();
		this.id = id;
	}
	public CompanyDto(Long id, String name, List<TeaDto> teaList) {
		super();
		this.id = id;
		this.name = name;
		this.teaList = teaList;
	}
	
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public List<TeaDto> getTeaList() { return teaList; }
	public void setTeaList(List<TeaDto> teaList) { this.teaList = teaList; }
		
	public UserDto getAddedByUser() { return addedByUser; }
	public void setAddedByUser(UserDto addedByUser) { this.addedByUser = addedByUser; }
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		CompanyDto other = (CompanyDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		return "CompanyDto [id=" + id + ", "
						 + "name=" + name 
						 + "]";
	}
	
}
