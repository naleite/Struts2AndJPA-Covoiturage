package my.na.covoiturage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import my.na.covoiturage.util.SingletonManager;

//@PersistenceContext(name = "persistence/messagerie",unitName = "messagerie")
public abstract class AbstractGenericDAO<T> implements IDAOGeneric<T> {

	private static final String PATTERN_FROM = "from " ;
	
	
	protected EntityManager em; 
	
	/**
	 * 
	 */
	public AbstractGenericDAO() {
		super();

		openEntityManager();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<T> getAll(final Class clazz) {
		openEntityManager();
		try {
            List<T> objects = null;
            final Query query = em.createQuery(PATTERN_FROM + clazz.getName());
            objects = query.getResultList();
            return objects;
        } catch (final Exception e) {
            
            throw new PersistenceException(e.getMessage(), e);
        }
		finally{
			closeEntityManager();
		}
    }

	@Override
	public void saveOrUpdate(T t) {
		//EntityTransaction tx = em.getTransaction();
		if(em==null|| !em.isOpen()){
			em=SingletonManager.getEntityManager();
		}
		try{
			
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			
			
		}
		catch(Exception e){
			throw new PersistenceException(e.getMessage(), e);
			//em.getTransaction().rollback();
			
		}
		finally{
			if(em!=null){
				em.close();
			}
			
		}
		

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void delete(Class clazz,Long id) {
		openEntityManager();
		 try {
			 em.getTransaction().begin();
			 T db = (T) em.find(clazz, id);
			 if(db==null){
				 throw new PersistenceException("No such entity ("+clazz.getName()+", id="+id+" ) in database. ");
			 }
	         em.remove(db);
	         em.getTransaction().commit();
	        } catch (final Exception e) {
	        	em.getTransaction().rollback();
	            throw new PersistenceException(e.getMessage(), e);
	        }
		 finally{
			 closeEntityManager() ;
		 }

	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public T getById(Class clazz, Long id) {
		openEntityManager();
		try {
            T t = null;
            t = (T) em.find(clazz, id);
            return t;
        } catch (final Exception e) {
            
            throw new PersistenceException(e.getMessage(), e);
        }
		finally{
			closeEntityManager();
		}
	}

	protected final EntityManager getEm() {
		return em;
	}

	@Override
	public void flush() {
		openEntityManager();
		em.flush();
		em.clear();
		closeEntityManager();
		
	}

	protected void openEntityManager() {
		if(em==null|| !em.isOpen()){
			em=SingletonManager.getEntityManager();
		}
	}

	protected void closeEntityManager() {
		if(em!=null){
			em.close();
		}

	}

	@Override
	protected void finalize() throws Throwable {
		if(em!=null){
			em.close();
		}
		
		super.finalize();
	}
	
	
	

}
