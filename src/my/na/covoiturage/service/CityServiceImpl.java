package my.na.covoiturage.service;

import java.util.ArrayList;
import java.util.List;

import my.na.covoiturage.dao.CityDAOImpl;
import my.na.covoiturage.dao.ICityDAO;
import my.na.covoiturage.model.City;

import com.opensymphony.xwork2.ActionSupport;



public class CityServiceImpl implements ICityService{
	

	
	ICityDAO cityDAO = new CityDAOImpl();

	@Override
	public List<City> getAllCities() {
		try{
			
			List<City> listCity = cityDAO.getAll(City.class);
			return listCity;
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<City> findCitiesByNameOrCode(String name, Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void deleteCity(Long cityId) {
		//City city = cityDAO.getById(City.class, cityId);
		cityDAO.delete(City.class, cityId);
		
	}

	@Override
	public void addCityByNameAndCode(String name, Integer code) {
		try{
			City city = new City(name, code);
			City citydb = cityDAO.getByCode(code);
			
			if(citydb==null){
				cityDAO.saveOrUpdate(city);
			}
			else{
				citydb.setName(name);
				cityDAO.saveOrUpdate(citydb);
			}
			
		}catch(Exception e){}
		
		
	}

	@Override
	public void addCityByCity(City city) {
		try{
		City citydb = cityDAO.getByCode(city.getPostalCode());
		
		if(citydb==null){
			cityDAO.saveOrUpdate(city);
		}
		else{
			citydb.setName(city.getName());
			cityDAO.saveOrUpdate(citydb);
		}
		
	}catch(Exception e){}
		
	}
	
	

}
