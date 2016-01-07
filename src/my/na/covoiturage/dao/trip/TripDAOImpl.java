package my.na.covoiturage.dao.trip;

import java.util.Date;
import java.util.List;

import my.na.covoiturage.dao.AbstractGenericDAO;
import my.na.covoiturage.model.City;
import my.na.covoiturage.model.Trip;
import my.na.covoiturage.model.User;

public class TripDAOImpl extends AbstractGenericDAO<Trip> implements ITripDAO {

	

	@Override
	public List<Trip> getAllTripsByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trip> getTripsByDepartCity(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trip> getTripsByArrivalCity(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trip> getTripsByDepartTime(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
