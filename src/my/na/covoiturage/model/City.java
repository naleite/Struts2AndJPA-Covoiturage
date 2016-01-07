package my.na.covoiturage.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: City
 *
 */
@Entity

public class City implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private Integer postalCode;
	

	public City() {
		super();
	}   
	
	
	/**
	 * @param name
	 * @param postalCode
	 */
	public City(String name, Integer postalCode) {
		super();
		this.name = name;
		this.postalCode = postalCode;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Integer getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	
   
}
