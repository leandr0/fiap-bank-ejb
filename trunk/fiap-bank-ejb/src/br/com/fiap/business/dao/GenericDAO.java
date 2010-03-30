/**
 * 
 */
package br.com.fiap.business.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import br.com.fiap.business.dao.interfaces.BasicDAO;
import br.com.fiap.business.exceptions.DAOException;
import br.com.fiap.domain.entity.EntityBasic;

/**
 * @author leandro.goncalves
 *
 */

public abstract class GenericDAO<T extends EntityBasic> implements BasicDAO<T> {

	@PersistenceContext(unitName = "fiap")
	EntityManager entityManager;

	public void delete(T t) throws DAOException{
		entityManager.remove(t);
	}

	@SuppressWarnings("unchecked")
	public T find(T t) throws DAOException{
		return (T) entityManager.find(t.getClass(), t);
	}

	public T insert(T t) throws DAOException{
		entityManager.persist(t);
		return t;
	}

	@SuppressWarnings("unchecked")
	public List<T> selectAll(Class<T> c) throws DAOException{
		entityManager.getTransaction().begin();
		return ((Session)entityManager.getDelegate()).createCriteria(c).list();
	}

	public T update(T t) throws DAOException{
		return entityManager.merge(t);
	}
}
