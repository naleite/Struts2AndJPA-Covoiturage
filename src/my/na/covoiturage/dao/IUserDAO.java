package my.na.covoiturage.dao;

import java.util.List;

import my.na.covoiturage.model.Trip;
import my.na.covoiturage.model.User;

public interface IUserDAO extends IDAOGeneric<User> {

	User getByUserName(String userName);
	List<User> getAllPassengersByTrip(Trip trip);
}
