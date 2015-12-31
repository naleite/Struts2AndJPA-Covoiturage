package my.na.covoiturage.dao;

import java.util.List;

import javax.persistence.Query;

import my.na.covoiturage.model.City;

public class CityDAOImpl extends AbstractGenericDAO<City> implements ICityDAO {

	
	
	/**
	 * 
	 */
	public CityDAOImpl() {
		super();
		openEntityManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> getByName(String name) {
		String qstr = "from City c where c.name = :name";
		Query query = em.createQuery(qstr);
		query.setParameter("name", name);
		List<City> list = query.getResultList();
		
		return list;
	}

	@Override
	public City getByCode(Integer code) {
		String qstr = "from City c where c.postalCode = :postalCode";
		Query query = em.createQuery(qstr);
		query.setParameter("postalCode", code);
		List<City> list = query.getResultList();
		City res = null;
		if(list !=null && !list.isEmpty()){
			res = list.get(0);
			
		}
		return res;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer strBuff = new StringBuffer("em = ");
		strBuff.append(em==null?"null":"notnull");
		return strBuff.toString();
	}

	
}
