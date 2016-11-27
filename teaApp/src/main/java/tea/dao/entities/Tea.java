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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The central entity of the app.
 *
 * @author mmihai
 */
@Entity
@Table(name = "tea")
public class Tea implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) @Column(name = "id")
    private Long id;
    
    @Basic(optional = false) @Column(name = "name")
    private String name;
    
    // Values: "T" or "F"
    @Column(name = "has_caffeine")
    private String hasCaffeine;
    
    @Column(name = "temperature_c")
    private Integer temperatureC;
    
    @Column(name = "infusion_time_s")
    private Integer infusionTimeS;
    
    @Column(name = "quantity_g")
    private Integer quantityG;
    
    @Column(name = "quantity_water_ml")
    private Integer quantityWaterML;
    
    @JoinColumn(name = "id_company", referencedColumnName = "id")
    @ManyToOne
    private Company company;
    
    @JoinColumn(name = "id_tea_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TeaType teaType;
    
    // TODO - check if correct
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tea")
    private List<RatingsByUser> ratingsByUserList;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "own_tea", 
			joinColumns = { @JoinColumn(name = "id_tea", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "id_user", nullable = false, updatable = false) })
    private List<User> teaOwnedByUsers;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "want_tea", 
			joinColumns = { @JoinColumn(name = "id_tea", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "id_user", nullable = false, updatable = false) })
    private List<User> teaWantedByUsers;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tea_ingredient", 
			joinColumns = { @JoinColumn(name = "id_tea", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "id_ingredient", nullable = false, updatable = false) })
    private List<Ingredient> ingredientList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tea_flavour", 
			joinColumns = { @JoinColumn(name = "id_tea", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "id_flavour", nullable = false, updatable = false) })
    private List<Flavour> flavourList;

    
    public Tea() { }
    public Tea(Long id) { this.id = id; }
    public Tea(String name) { this.name = name; }
    public Tea(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public Integer getQuantityQ() { return quantityG; }
    public void setQuantityQ(Integer quantityQ) { this.quantityG = quantityQ; }

    public Integer getQunatityWaterMl() { return quantityWaterML; }
    public void setQunatityWaterMl(Integer qunatityWaterMl) { this.quantityWaterML = qunatityWaterMl; }

    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }

    public TeaType getTeaType() { return teaType; }
    public void setTeaType(TeaType teaType) { this.teaType = teaType; }

    public List<RatingsByUser> getRatingsByUserList() { return ratingsByUserList; }
    public void setRatingsByUserList(List<RatingsByUser> ratingsByUserList) { this.ratingsByUserList = ratingsByUserList; }

    public List<User> getOwnedUsersList() { return teaOwnedByUsers; }
    public void setOwnedUsersList(List<User> teaOwnedByUsers) { this.teaOwnedByUsers = teaOwnedByUsers; }
    
    public List<User> getWantedUsersList() { return teaWantedByUsers; }
    public void setWantedUsersList(List<User> teaWantedByUsers) { this.teaOwnedByUsers = teaWantedByUsers; }

    public List<Ingredient> getIngredientList() { return ingredientList; }
    public void setIngredientList(List<Ingredient> ingredientList) { this.ingredientList = ingredientList; }
    
    public List<Flavour> getFlavourList() { return flavourList; }
    public void setFlavourList(List<Flavour> flavourList) { this.flavourList = flavourList; }
    
    
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
		
		Tea other = (Tea) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		return "Tea [id=" + id + ", "
				  + "name=" + name + ", "
				  + "hasCaffeine=" + hasCaffeine + ", "
				  + "temperatureC=" + temperatureC
				  + ", infusionTimeS=" + infusionTimeS + ", "
				  + "quantityG=" + quantityG + ", "
				  + "quantityWaterML=" + quantityWaterML 
				  + "]";
	}
	
}
