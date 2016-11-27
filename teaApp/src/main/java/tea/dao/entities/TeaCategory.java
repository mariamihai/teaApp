package tea.dao.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The category of the tea. Main categories are: white, green, oolong, black...
 * 
 * @author mmihai
 */
@Entity
@Table(name = "tea_category")
public class TeaCategory implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) @Column(name = "id")    
    private Long id;    
    @Basic(optional = false) @Column(name = "name")
    private String name;

    
    public TeaCategory() {}
    public TeaCategory(Long id) {this.id = id;}
    public TeaCategory(String name) {this.name = name;}
    public TeaCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
	
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
		
		TeaCategory other = (TeaCategory) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return "TeaCategory [id=" + id + ", "
						  + "name=" + name
						  + "]";
	}
    
}
