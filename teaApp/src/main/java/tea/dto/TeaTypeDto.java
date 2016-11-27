package tea.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeaTypeDto {
	
	
	private Long id;
    private String name;
    private TeaCategoryDto category;
    @JsonBackReference
    private List<TeaDto> teaList;
    
    
    public TeaTypeDto() { }
    public TeaTypeDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public TeaTypeDto(Long id, String name, TeaCategoryDto category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}
	
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public TeaCategoryDto getCategory() { return category; }
	public void setCategory(TeaCategoryDto category) { this.category = category; }
		
	public List<TeaDto> getTeaList() { return teaList; }
	public void setTeaList(List<TeaDto> teaList) { this.teaList = teaList; }
	
	
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
		
		TeaTypeDto other = (TeaTypeDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}
	@Override
	public String toString() {
		return "TeaTypeDto [id=" + id + ", "
						 + "name=" + name 
						 + "]";
	}
	
}
