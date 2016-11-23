package tea.dao.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * App's user.
 *
 * @author mmihai
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false) @Column(name = "id")
    private Long id;
    
    @Basic(optional = false) @Column(name = "username")
    private String username;
    
    @Basic(optional = false) @Column(name = "email_address")
    private String emailAddress;
    
    @Column(name = "password")
    private String password;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<RatingsByUser> ratingsByUserList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addedByUser")
    private List<Company> companyList;  

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "teaOwnedByUsers")
    private List<Tea> ownedTeaList;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "teaWantedByUsers")
    private List<Tea> wantedTeaList;
    

    public User() { }
    public User(Long id) { this.id = id; }
    public User(Long id, String username, String emailAddress) {
        this.id = id;
        this.username = username;
        this.emailAddress = emailAddress;
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<RatingsByUser> getRatingsByUserList() { return ratingsByUserList; }
    public void setRatingsByUserList(List<RatingsByUser> ratingsByUserList) { this.ratingsByUserList = ratingsByUserList; }

    public Collection<Company> getCompanyList() { return companyList; }
    public void setCompanyList(List<Company> companyList) { this.companyList = companyList; }
    
    public List<Tea> getOwnedTeaList(){ return ownedTeaList; }
    public void setOwnedTeaList(List<Tea> ownedTeaList) { this.ownedTeaList = ownedTeaList; }
    
    public List<Tea> getWantedTeaList(){ return wantedTeaList; }
    public void setWantedTeaList(List<Tea> wantedTeaList) { this.wantedTeaList = wantedTeaList; }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", "
				   + "username=" + username + ", "
			   	   + "emailAddress=" + emailAddress + ", "
				   + "password=" + password
				   + "]";
	}
    
}
