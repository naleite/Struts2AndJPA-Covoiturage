package my.na.covoiturage.service.car;

import java.util.List;

import my.na.covoiturage.model.Car;
import my.na.covoiturage.util.InformationErrorException;

public interface ICarService {

	void addCarForUser(String username, String carCode, Integer seats) throws InformationErrorException;
	
	List<Car> getCarsOfUser(String username) throws InformationErrorException;
	
	void deleteCarOfUser(String username,String carCode) throws InformationErrorException;
	
	

	void updateCarOfUser(String username, String carCode, Integer seats)
			throws InformationErrorException;
	
}
