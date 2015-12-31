package my.na.covoiturage.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;

import javax.persistence.*;

import my.na.covoiturage.model.User;

/**
 * Entity implementation class for Entity: Car
 *
 */
@Entity

public class Car implements Serializable {

	
	private static final long serialVersionUID = 1L;
	public static final String CAR_ID = "car_id";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = CAR_ID)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String code;
	
	@ManyToOne(optional = false, 
			targetEntity = User.class,
			cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}
	)
	private User owner;
	
	private Integer seatAvailable;

	public Car() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}   
	public User getOwner() {
		return this.owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	public Integer getSeatAvailable() {
		return seatAvailable;
	}
	public void setSeatAvailable(Integer seatAvailable) {
		this.seatAvailable = seatAvailable;
	}
	
	
   
}
