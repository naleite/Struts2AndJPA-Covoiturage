package my.na.covoiturage.dao.car;

import java.util.List;

import javax.persistence.Query;

import my.na.covoiturage.dao.AbstractGenericDAO;
import my.na.covoiturage.model.Car;
@SuppressWarnings({ "unchecked", "null" })
public class CarDAOImpl extends AbstractGenericDAO<Car> implements ICarDAO {

	

	private static final String QUERY_BY_CODE = "from Car c where c.code = :code";
	
	private static final String QUERY_BY_OWNER = "from Car c where c.owner = (select u from User u where u.name = :ownerName)";

	
	@Override
	public List<Car> getByCarOwner(String ownerUserName) {
		Query q = em.createQuery(QUERY_BY_OWNER);
		q.setParameter("ownerName", ownerUserName);
		List<Car> list = q.getResultList();
		
		
		return list;
	}

	
	@Override
	public Car getByCarCode(String code) {
		Query q = em.createQuery(QUERY_BY_CODE);
		q.setParameter("code", code);
		List<Car> list = q.getResultList();
		Car res = null;
		if(list !=null && !list.isEmpty()){
			res = list.get(0);
			
		}
		return res;
	}

}
