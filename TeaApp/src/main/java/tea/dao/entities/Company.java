package tea.dao.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mmihai
 */
@Entity
@Table(name = "company")
public class Company implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false) @Column(name = "id")
    private Long id;
    
    @Basic(optional = false) @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "company")
    private List<Tea> teaList;
    
    @JoinColumn(name = "added_by_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User addedByUser;

    
    public Company() { }
    public Company(Long id) { this.id = id; }
    public Company(Long id, String name) {
        this.id = id;
        this.name = name;
    }    
    public Company(Long id, String name, User addedByUser) {
		super();
		this.id = id;
		this.name = name;
		this.addedByUser = addedByUser;
	}
    
    
	public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Tea> getTeaList() { return teaList; }
    public void setTeaList(List<Tea> teaList) { this.teaList = teaList; }

    public User getAddedByUser() { return addedByUser; }
    public void setAddedByUser(User addedByUser) { this.addedByUser = addedByUser; }
    
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		
		Company other = (Company) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", "
					  + "name=" + name
					  + "]";
	}
    
}
