package my.na.covoiturage.service.user;

import java.util.List;

import my.na.covoiturage.model.Trip;
import my.na.covoiturage.model.User;
import my.na.covoiturage.util.InformationErrorException;

public interface IUserService {

	void createUser(String username, String password) throws InformationErrorException;
	
	List<User> getAllUsers() throws InformationErrorException;
	
	void joinOneTrip(Trip trip) throws InformationErrorException;
	
	void resetPassword(String oldPwd,String newPwd) throws InformationErrorException;
	
	User checkUser(String username, String pwd) throws InformationErrorException;
}
