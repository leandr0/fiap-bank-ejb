/**
 * 
 */
package br.com.fiap.domain.jpa.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

/**
 * @author User
 *
 */
public class JPAConfig {
	/**
	 * 
	 */
	private static EntityManagerFactory entityManagerFactory;
	
	/**
	 * 
	 */
	protected EntityManager manager;
	
	
	/**
	 * 
	 */
	protected Session session;
	
	static{
		entityManagerFactory = Persistence.createEntityManagerFactory("fiap"); 
	}

	protected EntityManager getEntityManager(){
		if ( manager == null || !manager.isOpen() )		
				manager = createEntityManager();		
		return manager;
	}
	
	protected Session getSessionHibernate(){		
		if ( session == null || !session.isOpen() )	
				session = createSessionHib();		
		return session;
	}
	
	public Session getNewSessionHibernate(){								
		return createSessionHib();
	}
	
	private EntityManager createEntityManager(){
		return entityManagerFactory.createEntityManager();
	}
	
	private Session createSessionHib() {
		return (Session) entityManagerFactory.createEntityManager().getDelegate();
	}	

	protected void closeManager(){		
		if ( manager != null && manager.isOpen())
				manager.close();		
	}
	
	protected void closeSession(){		
		if ( session != null && session.isOpen())
				session.close();		
	}
	
	protected void flush(){		
		if ( session != null && session.isOpen())
				session.flush();		
		if ( manager != null && manager.isOpen())
				manager.flush();
	}
	
	protected void begin(){
		getEntityManager().getTransaction().begin(); 
	}
	
	protected void commit(){
		 manager.getTransaction().commit();
	}
		
	protected void rollbackManager(){		
		if ( manager != null && manager.isOpen())
			if ( manager.getTransaction().isActive() )
				 manager.getTransaction().rollback();			
	}
	
	protected void clear(){		
		if (session != null && session.isOpen())
			session.clear();
		if ( manager != null && manager.isOpen())
			manager.clear();
	}
}
