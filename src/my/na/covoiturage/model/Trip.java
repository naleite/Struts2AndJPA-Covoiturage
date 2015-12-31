package my.na.covoiturage.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Trip
 *
 */
@Entity

public class Trip implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String TRIP_ID = "trip_id";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = TRIP_ID)
	private Long id;
	
	@Column(nullable = false)
	private Date departTime;
	
	@Column(nullable = false)
	private Short TimeOnTrip;
	
	@Column(nullable = false)
	private City departCity;
	
	@Column(nullable = false)
	private City arrivalCity;
	
	@Column(nullable = false)
	@JoinColumn(referencedColumnName = User.USER_ID)
	private User driver;
	
	@Column(nullable = false)
	@JoinColumn(referencedColumnName = Car.CAR_ID)
	private Car carForMission;
	
	@ManyToMany(mappedBy = "trips", cascade = CascadeType.ALL)
	private Set<User> passengers = new HashSet<User>();
		

	public Trip() {
		super();
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Date getDepartTime() {
		return departTime;
	}




	public void setDepartTime(Date departTime) {
		this.departTime = departTime;
	}




	public Short getTimeOnTrip() {
		return TimeOnTrip;
	}




	public void setTimeOnTrip(Short timeOnTrip) {
		TimeOnTrip = timeOnTrip;
	}




	public City getDepartCity() {
		return departCity;
	}




	public void setDepartCity(City departCity) {
		this.departCity = departCity;
	}




	public City getArrivalCity() {
		return arrivalCity;
	}




	public void setArrivalCity(City arrivalCity) {
		this.arrivalCity = arrivalCity;
	}




	public User getDriver() {
		return driver;
	}




	public void setDriver(User driver) {
		this.driver = driver;
	}




	public Car getCarForMission() {
		return carForMission;
	}




	public void setCarForMission(Car carForMission) {
		this.carForMission = carForMission;
	}




	public Set<User> getPassengers() {
		return passengers;
	}




	public void setPassengers(Set<User> passengers) {
		this.passengers = passengers;
	}   

	
   
}
