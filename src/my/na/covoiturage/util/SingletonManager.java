package my.na.covoiturage.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public final class SingletonManager {

	
	private static volatile EntityManagerFactory emf ;
	
	
	private SingletonManager(){
		super();
	
	}
	
	private static final EntityManagerFactory factory(){
		if (SingletonManager.emf == null) {
		       
	        synchronized(SingletonManager.class) {
	          if (SingletonManager.emf == null) {
	        	  //emf
	        	  SingletonManager.emf =Persistence.createEntityManagerFactory("dev");
	          }
	        }
	     }
	     return SingletonManager.emf;

	}
	
	public static final EntityManager getEntityManager(){
		
	          
	        	  
	        	  return factory().createEntityManager();
	          
	       
	     
	     
	}
		
		
	
}
