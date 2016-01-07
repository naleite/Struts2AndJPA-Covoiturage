package my.na.covoiturage.service.car;

import java.util.List;

import my.na.covoiturage.dao.car.CarDAOImpl;
import my.na.covoiturage.dao.car.ICarDAO;
import my.na.covoiturage.dao.user.IUserDAO;
import my.na.covoiturage.dao.user.UserDAOImpl;
import my.na.covoiturage.model.Car;
import my.na.covoiturage.model.User;
import my.na.covoiturage.util.InformationErrorException;

public class CarServiceImpl implements ICarService {

	private ICarDAO carDAO ;
	private IUserDAO userDAO;
	
	public CarServiceImpl() {
		carDAO = new CarDAOImpl();
		userDAO = new UserDAOImpl();
	}

	@Override
	public void addCarForUser(String username, String carCode, Integer seats) throws InformationErrorException {
		
		User user = userDAO.getByUserName(username);
		Car cardb = carDAO.getByCarCode(carCode);
		if(user==null){
			throw new InformationErrorException("No such user");
		}
		if(cardb!=null){
			throw new InformationErrorException("This car has been registed by another user");
		}
		if(cardb==null && user!=null){
			Car newCar = new Car();
			newCar.setCode(carCode);
			newCar.setOwner(user);
			newCar.setSeatAvailable(seats);
			carDAO.saveOrUpdate(newCar);
		}
		
		
	}

	@Override
	public List<Car> getCarsOfUser(String username) throws InformationErrorException {
		User user = userDAO.getByUserName(username);
		if(user==null){
			throw new InformationErrorException("No such user");
		}
		return carDAO.getByCarOwner(username);
		
	}

	@Override
	public void deleteCarOfUser(String username, String carCode) throws InformationErrorException {
		User user = userDAO.getByUserName(username);
		Car cardb = carDAO.getByCarCode(carCode);
		if(user==null){
			throw new InformationErrorException("No such user");
		}
		if(cardb==null){
			throw new InformationErrorException("This car has not been registed, please ");
		}
		carDAO.delete(Car.class, cardb.getId());
	}

	@Override
	public void updateCarOfUser(String username, String carCode,Integer seats) throws InformationErrorException {
		User user = userDAO.getByUserName(username);
		Car cardb = carDAO.getByCarCode(carCode);
		if(user==null){
			throw new InformationErrorException("No such user");
		}
		if(cardb!=null){
			throw new InformationErrorException("This car has been registed by another user");
		}
		if(cardb==null && user!=null){
			Car newCar = new Car();
			newCar.setCode(carCode);
			newCar.setOwner(user);
			newCar.setSeatAvailable(seats);
			carDAO.saveOrUpdate(newCar);
		}
		
	}

	

	

}
