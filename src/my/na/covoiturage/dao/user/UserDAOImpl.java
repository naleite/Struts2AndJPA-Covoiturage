package my.na.covoiturage.dao.user;

import java.util.List;

import javax.persistence.Query;

import my.na.covoiturage.dao.AbstractGenericDAO;
import my.na.covoiturage.model.Trip;
import my.na.covoiturage.model.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UserDAOImpl extends AbstractGenericDAO<User> implements IUserDAO {

	private static final String QUERY_BY_NAME="from User u where u.username = :name";
	
	private static final String CHECK_USER="from User u where u.username = :name and u.password = :pwd";
	
	@Override
	public User getByUserName(String userName) {
		Query q = em.createQuery(QUERY_BY_NAME);
		q.setParameter("name", userName);
		List<User> list = q.getResultList();
		User res = null;
		if(list!=null && !list.isEmpty()){
			res=list.get(0);
		}
		return res;
	}

	@Override
	public List<User> getAllPassengersByTrip(Trip trip) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public User checkUser(String name, String pwd) {
		Query q = em.createQuery(CHECK_USER);
		q.setParameter("name", name);
		q.setParameter("pwd", pwd);
		List<User> list = q.getResultList();
		User res = null;
		if(list!=null && !list.isEmpty()){
			res=list.get(0);
		}
		
		return res;
	}

}
