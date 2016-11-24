package tea.dto;

import java.util.List;

public class UserDto {
	
	
	private Long id;
    private String username;
    private String emailAddress;
    private String password;
    private List<RatingsByUserDto> ratingsByUserList;
    private List<CompanyDto> companyList;  
    private List<TeaDto> ownedTeaList;
    private List<TeaDto> wantedTeaList;
    
    
	public UserDto() { }
	public UserDto(Long id) {
		super();
		this.id = id;
	}
	public UserDto(Long id, String username, String emailAddress, String password) {
		super();
		this.id = id;
		this.username = username;
		this.emailAddress = emailAddress;
		this.password = password;
	}
	
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getUsername() { return username;}
	public void setUsername(String username) { this.username = username; }
	
	public String getEmailAddress() { return emailAddress; }
	public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public List<RatingsByUserDto> getRatingsByUserList() { return ratingsByUserList; }
	public void setRatingsByUserList(List<RatingsByUserDto> ratingsByUserList) { 
		this.ratingsByUserList = ratingsByUserList;
	}
	
	public List<CompanyDto> getCompanyList() { return companyList; }
	public void setCompanyList(List<CompanyDto> companyList) { this.companyList = companyList; }
	
	public List<TeaDto> getOwnedTeaList() { return ownedTeaList; }
	public void setOwnedTeaList(List<TeaDto> ownedTeaList) { this.ownedTeaList = ownedTeaList; }
	
	public List<TeaDto> getWantedTeaList() { return wantedTeaList; }
	public void setWantedTeaList(List<TeaDto> wantedTeaList) { this.wantedTeaList = wantedTeaList; }
	
	
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
		
		UserDto other = (UserDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", "
					  + "username=" + username + ", "
					  + "emailAddress=" + emailAddress + ", "
					  + "password=" + password 
					  + "]";
	}
    
}
