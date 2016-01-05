package my.na.covoiturage.action.city;

import java.util.ArrayList;
import java.util.List;

import my.na.covoiturage.dao.ICityDAO;
import my.na.covoiturage.model.City;
import my.na.covoiturage.service.CityServiceImpl;
import my.na.covoiturage.service.ICityService;

public class CityAction {

	private ICityService cityService = new CityServiceImpl();
	private String errorMessage = "Hello error";
	private List<City> listCity = new ArrayList<City>();
	private CityVO newCity;
	private Long idCityToDelete;
	private String cityDepart;
	
	public String allCities() throws Exception{
		
		try{
			
			listCity = cityService.getAllCities();
			return "success";
		}catch(Exception e){
			setErrorMessage(e.getMessage());
			e.printStackTrace();
		}
		return "error";
		
	}
	
	public String addCity(){
		try{
			cityService.addCityByCity(newCity.cloneCity());
			return "success";
		}catch(Exception e){}
		return "error";
	}
	
	public String deleteCity(){
		cityService.deleteCity(idCityToDelete);
		
		return "success";
	}
	public final String getErrorMessage() {
		return errorMessage;
	}
	public final void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public final List<City> getListCity() {
		return listCity;
	}
	public final void setListCity(List<City> listCity) {
		this.listCity = listCity;
	}

	

	public final CityVO getNewCity() {
		return newCity;
	}

	public final void setNewCity(CityVO newCity) {
		this.newCity = newCity;
	}

	public final ICityService getCityService() {
		return cityService;
	}

	public final void setCityService(ICityService cityService) {
		this.cityService = cityService;
	}

	public final Long getIdCityToDelete() {
		return idCityToDelete;
	}

	public final void setIdCityToDelete(Long idCityToDelete) {
		this.idCityToDelete = idCityToDelete;
	}

	

	public final String getCityDepart() {
		return cityDepart;
	}

	public final void setCityDepart(String cityDepart) {
		this.cityDepart = cityDepart;
	}

	public String cityChoose(){
		
		return "choose";
	}
	
	
	
	
}
