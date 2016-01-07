package my.na.covoiturage.dao.user;

import java.util.List;

import my.na.covoiturage.dao.IDAOGeneric;
import my.na.covoiturage.model.Trip;
import my.na.covoiturage.model.User;

public interface IUserDAO extends IDAOGeneric<User> {

	User getByUserName(String userName);
	List<User> getAllPassengersByTrip(Trip trip);
	User checkUser(String name, String pwd);
}
