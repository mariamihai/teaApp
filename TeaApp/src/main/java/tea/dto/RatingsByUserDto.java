package tea.dto;

public class RatingsByUserDto {
	
	
	private Long id;
    private int rating;
    private TeaDto tea;
    private UserDto user;
    
    
	public RatingsByUserDto() { }
	public RatingsByUserDto(Long id) { this.id = id; }
	public RatingsByUserDto(Long id, int rating) {
		this.id = id;
		this.rating = rating;
	}
	
	
	public Long getId() { return id;}
	public void setId(Long id) { this.id = id; }
	
	public int getRating() { return rating; }
	public void setRating(int rating) { this.rating = rating; }
	
	public TeaDto getTea() { return tea; }
	public void setTea(TeaDto tea) { this.tea = tea; }
	
	public UserDto getUser() { return user; }
	public void setUser(UserDto user) { this.user = user; }
	
	
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
		
		RatingsByUserDto other = (RatingsByUserDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		return "RatingsByUserDto [id=" + id + ", "
							   + "rating=" + rating
							   + "]";
	}
    
}
