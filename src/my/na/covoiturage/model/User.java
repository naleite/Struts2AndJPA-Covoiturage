package my.na.covoiturage.model;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String USER_ID = "user_id";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = USER_ID)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false, unique = true)
	private String userCode;
	
	@Column(nullable = false)
	private String password;
		
	
	@ManyToMany	
	@JoinTable(
		      name="user_trip",
		      joinColumns={@JoinColumn(name=USER_ID, referencedColumnName=USER_ID)},
		      inverseJoinColumns={@JoinColumn(name=Trip.TRIP_ID, referencedColumnName=Trip.TRIP_ID)})
	private Set<Trip> trips = new HashSet<Trip>();
	

	public User() {
		super();
	}   
	
	
	/**
	 * @param username
	 * @param password
	 * @param cars
	 */
	public User(String username, String password) {
		super();
		
		this.password = password;
		
		setUsername(username);
		
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
		setUserCode(username.toLowerCase().trim());
		
	}   
	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Trip> getTrips() {
		return trips;
	}


	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}






   
}
