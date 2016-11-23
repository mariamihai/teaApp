package tea.dao.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mmihai
 */
@Entity
@Table(name = "ratings_by_user")
public class RatingsByUser implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false) @Column(name = "id")
    private Long id;
    
    @Basic(optional = false) @Column(name = "rating")
    private int rating;
    
    @JoinColumn(name = "id_tea", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tea tea;
    
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;

    
    public RatingsByUser() { }
    public RatingsByUser(Long id) { this.id = id; }
    public RatingsByUser(Long id, int rating) {
        this.id = id;
        this.rating = rating;
    }
    public RatingsByUser(Long id, int rating, Tea tea, User user) {
		super();
		this.id = id;
		this.rating = rating;
		this.tea = tea;
		this.user = user;
	}
    
    
	public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public Tea getTea() { return tea; }
    public void setTea(Tea tea) { this.tea = tea; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + rating;
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
		
		RatingsByUser other = (RatingsByUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}
	@Override
	public String toString() {
		return "RatingsByUser [id=" + id + ", "
							+ "rating=" + rating
							+ "]";
	}
    
}
