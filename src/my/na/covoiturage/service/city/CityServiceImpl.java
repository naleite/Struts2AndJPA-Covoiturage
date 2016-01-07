package my.na.covoiturage.service.city;

import java.util.ArrayList;
import java.util.List;

import my.na.covoiturage.dao.city.CityDAOImpl;
import my.na.covoiturage.dao.city.ICityDAO;
import my.na.covoiturage.model.City;



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
		
		List<City> list = null;
		if((name == null||name.isEmpty()) && (code==null||code.intValue()==0)){
			return getAllCities();
		}
		if(name==null || name.isEmpty()){
			list = new ArrayList<City>();
			City city = cityDAO.getByCode(code);
			if(city!=null){
				list.add(city);
			}
		}
		else if(code == null || code.intValue()==0){
			list = cityDAO.getByName(name);
		}
		else{
			list = new ArrayList<City>();
			City city = cityDAO.getByNameAndCode(name, code);
			if(city!=null){
				list.add(city);
			}
		}
		return list;
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
