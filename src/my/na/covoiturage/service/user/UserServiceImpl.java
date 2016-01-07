package my.na.covoiturage.service.user;

import java.util.List;

import my.na.covoiturage.dao.user.IUserDAO;
import my.na.covoiturage.dao.user.UserDAOImpl;
import my.na.covoiturage.model.Trip;
import my.na.covoiturage.model.User;
import my.na.covoiturage.util.InformationErrorException;

public class UserServiceImpl implements IUserService {
	
	private IUserDAO userDAO;

	public UserServiceImpl() {
		userDAO=new UserDAOImpl();
	}

	@Override
	public void createUser(String username, String password) throws InformationErrorException {
		User userdb = userDAO.getByUserName(username);
		if(userdb==null){
			User user = new User();
			user.setPassword(password);
			user.setUsername(username);
			userDAO.saveOrUpdate(user);
		}
		else{
			throw new InformationErrorException("username already exist. Please enter another");
		}

	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void joinOneTrip(Trip trip) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetPassword(String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User checkUser(String username, String pwd)
			throws InformationErrorException {
		
		User userdb = userDAO.checkUser(username, pwd);
		
		return userdb;
	}

}
