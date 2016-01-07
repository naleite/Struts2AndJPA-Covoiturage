package my.na.covoiturage.dao.trip;

import java.util.Date;
import java.util.List;

import my.na.covoiturage.dao.IDAOGeneric;
import my.na.covoiturage.model.City;
import my.na.covoiturage.model.Trip;
import my.na.covoiturage.model.User;

public interface ITripDAO extends IDAOGeneric<Trip> {

	List<Trip> getAllTripsByUser(User user);
	List<Trip> getTripsByDepartCity(City city);
	List<Trip> getTripsByArrivalCity(City city);
	List<Trip> getTripsByDepartTime(Date date);
	
}
