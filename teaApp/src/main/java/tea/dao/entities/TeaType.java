/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tea.dao.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The type of the tea.
 * 
 * @author mmihai
 */
@Entity
@Table(name = "tea_type")
public class TeaType implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) @Column(name = "id")
    private Long id;
    
    @Basic(optional = false) @Column(name = "name")
    private String name;
    
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TeaCategory category;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teaType")
    private List<Tea> teaList;

    
    public TeaType() { }
    public TeaType(Long id) { this.id = id; }
    public TeaType(String name) { this.name = name; }
    public TeaType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public TeaCategory getIdCategory() { return category; }
    public void setIdCategory(TeaCategory category) { this.category = category; }
    
    public List<Tea> getTeaList() { return teaList; }
    public void setTeaList(List<Tea> teaList) { this.teaList = teaList; }
    
    
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
		
		TeaType other = (TeaType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}
	@Override
	public String toString() {
		return "TeaType [id=" + id + ", "
					  + "name=" + name + ", "
					  + "category=" + category 
					  + "]";
	}
	
}
