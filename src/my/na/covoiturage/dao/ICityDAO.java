package my.na.covoiturage.dao;

import java.util.List;

import my.na.covoiturage.model.City;

public interface ICityDAO extends IDAOGeneric<City> {

	List<City> getByName(String name);
	
	City getByCode(Integer code);
}
