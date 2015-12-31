package my.na.covoiturage.dao;

import java.util.List;

public interface IDAOGeneric<T> {
	
	@SuppressWarnings("rawtypes")
	List<T> getAll(final Class clazz);
	void saveOrUpdate(T t);
	void delete(Class clazz, Long id);
	void flush();
	T getById(Class clazz, Long id);

}
