package my.na.covoiturage.action.car;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import my.na.covoiturage.model.Car;
import my.na.covoiturage.service.car.CarServiceImpl;
import my.na.covoiturage.service.car.ICarService;
import my.na.covoiturage.util.InformationErrorException;

public class CarAction extends ActionSupport{

	
	private static final long serialVersionUID = 1L;
	
	private static final String SUCCESS = "success";
	private static final String CARS = "cars";
	private ICarService carService;
	private String username;//?username = xxx来获取用户信息；
	private List<Car> listCar = new ArrayList<Car>();
	private String newCarCode;
	private Integer newCarSeats;
	public CarAction() {
		carService=new CarServiceImpl();
	}
	
	public String getAllCarForUser() throws Exception{
		try{
			this.listCar = carService.getCarsOfUser(username);
		}catch(InformationErrorException e){
			addActionError(e.getMsg());
			return CARS;
			
		}
		return SUCCESS;
	}
	
	public String addCarForUser(){
		try {
			carService.addCarForUser(username, newCarCode, newCarSeats);
		} catch (InformationErrorException e) {
			addActionError(e.getMsg());
			return CARS;
		}
		return SUCCESS;
	}

	public final ICarService getCarService() {
		return carService;
	}

	public final void setCarService(ICarService carService) {
		this.carService = carService;
	}

	public final String getUsername() {
		return username;
	}

	public final void setUsername(String username) {
		this.username = username;
	}

	public final List<Car> getListCar() {
		return listCar;
	}

	public final void setListCar(List<Car> listCar) {
		this.listCar = listCar;
	}

	
}
