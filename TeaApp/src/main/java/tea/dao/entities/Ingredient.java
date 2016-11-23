package tea.dao.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author mmihai
 */
@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false) @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "ingredientList")
    private List<Tea> teaList;

    
    public Ingredient() { }
    public Ingredient(Long id) { this.id = id; }
    public Ingredient(String name) { this.name = name; }
    
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Tea> getTeaIngredientsList() { return teaList; }
	public void setTeaIngredientsCollection(List<Tea> teaList) { this.teaList = teaList; }
    
    
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
		
		Ingredient other = (Ingredient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}
	@Override
	public String toString() {
		return "Ingredients [id=" + id + ", "
						  + "name=" + name + "]";
	}
    
}
