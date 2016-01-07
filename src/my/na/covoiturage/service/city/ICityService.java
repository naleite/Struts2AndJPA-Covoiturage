package my.na.covoiturage.service.city;

import java.util.List;

import my.na.covoiturage.model.City;

public interface ICityService {

	List<City> getAllCities();
	
	List<City> findCitiesByNameOrCode(String name,Integer code);
	
	void addCityByNameAndCode(String name, Integer code);
	
	void addCityByCity(City city);
	
	void deleteCity(Long cityId);
}
