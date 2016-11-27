package tea.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeaDto {
	
	
	private Long id;
    private String name;
    // Values: "T" or "F"
    private String hasCaffeine;
    private Integer temperatureC;
    private Integer infusionTimeS;
    private Integer quantityG;
    private Integer quantityWaterML;
    private CompanyDto company;
    @JsonManagedReference
    private TeaTypeDto teaType;
    private List<RatingsByUserDto> ratingsByUserList;
    private List<UserDto> teaOwnedByUsers;
    private List<UserDto> teaWantedByUsers;
    private List<IngredientDto> ingredientList;
    private List<FlavourDto> flavourList;
    
    
    public TeaDto() { }
    public TeaDto(Long id) {
		super();
		this.id = id;
    }
	public TeaDto(Long id, String name, String hasCaffeine, Integer temperatureC, Integer infusionTimeS,
			Integer quantityG, Integer quantityWaterML) {
		super();
		this.id = id;
		this.name = name;
		this.hasCaffeine = hasCaffeine;
		this.temperatureC = temperatureC;
		this.infusionTimeS = infusionTimeS;
		this.quantityG = quantityG;
		this.quantityWaterML = quantityWaterML;
	}
	
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getHasCaffeine() { return hasCaffeine; }
	public void setHasCaffeine(String hasCaffeine) { this.hasCaffeine = hasCaffeine; }
	
	public Integer getTemperatureC() { return temperatureC; }
	public void setTemperatureC(Integer temperatureC) { this.temperatureC = temperatureC; }
	
	public Integer getInfusionTimeS() { return infusionTimeS; }
	public void setInfusionTimeS(Integer infusionTimeS) { this.infusionTimeS = infusionTimeS; }
	
	public Integer getQuantityG() { return quantityG; }
	public void setQuantityG(Integer quantityG) { this.quantityG = quantityG; }
	
	public Integer getQuantityWaterML() { return quantityWaterML; }
	public void setQuantityWaterML(Integer quantityWaterML) { this.quantityWaterML = quantityWaterML; }
	
	public CompanyDto getCompany() { return company; }
	public void setCompany(CompanyDto company) { this.company = company; }
	
	public TeaTypeDto getTeaType() { return teaType; }
	public void setTeaType(TeaTypeDto teaType) { this.teaType = teaType; }
	
	public List<RatingsByUserDto> getRatingsByUserList() { return ratingsByUserList; }
	public void setRatingsByUserList(List<RatingsByUserDto> ratingsByUserList) { 
		this.ratingsByUserList = ratingsByUserList;
	}
	
	public List<UserDto> getTeaOwnedByUsers() { return teaOwnedByUsers; }
	public void setTeaOwnedByUsers(List<UserDto> teaOwnedByUsers) { this.teaOwnedByUsers = teaOwnedByUsers; }
	
	public List<UserDto> getTeaWantedByUsers() { return teaWantedByUsers; }
	public void setTeaWantedByUsers(List<UserDto> teaWantedByUsers) { this.teaWantedByUsers = teaWantedByUsers; }
	
	public List<IngredientDto> getIngredientList() { return ingredientList; }
	public void setIngredientList(List<IngredientDto> ingredientList) { this.ingredientList = ingredientList; }
	
	public List<FlavourDto> getFlavourList() { return flavourList; }
	public void setFlavourList(List<FlavourDto> flavourList) { this.flavourList = flavourList; }
	
	
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
		
		TeaDto other = (TeaDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		return "TeaDto [id=" + id + ", "
					 + "name=" + name + ", "
					 + "hasCaffeine=" + hasCaffeine + ", "
					 + "temperatureC=" + temperatureC + ", "
					 + "infusionTimeS=" + infusionTimeS + ", "
					 + "quantityG=" + quantityG + ", "
					 + "quantityWaterML=" + quantityWaterML 
					 + "]";
	}
    
}
