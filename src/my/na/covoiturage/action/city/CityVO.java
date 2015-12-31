package my.na.covoiturage.action.city;

import my.na.covoiturage.model.City;

public class CityVO{
	Long id;
	String name;
	Integer code;
	/**
	 * 
	 */
	public CityVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CityVO(City city){
		this.id = city.getId();
		this.name = city.getName();
		this.code = city.getPostalCode();
	}
	public final Long getId() {
		return id;
	}
	public final void setId(Long id) {
		this.id = id;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final Integer getCode() {
		return code;
	}
	public final void setCode(Integer code) {
		this.code = code;
	}
	
	 City cloneCity(){
		return new City(this.name,this.code);
	}
	
	
	
}