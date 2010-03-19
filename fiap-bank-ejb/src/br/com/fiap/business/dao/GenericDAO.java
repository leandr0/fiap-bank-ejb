/**
 * 
 */
package br.com.fiap.business.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import br.com.fiap.business.dao.interfaces.BasicDAO;
import br.com.fiap.domain.entity.EntityBasic;

/**
 * @author leandro.goncalves
 *
 */

public abstract class GenericDAO<T extends EntityBasic> implements BasicDAO<T> {

	@PersistenceContext(unitName = "fiap")
	EntityManager entityManager;

	public void delete(T t) {
		entityManager.remove(t);
	}

	@SuppressWarnings("unchecked")
	public T find(T t) {
		return (T) entityManager.find(t.getClass(), t);
	}

	public T insert(T t) {
		entityManager.persist(t);
		return t;
	}

	@SuppressWarnings("unchecked")
	public List<T> selectAll(Class<T> c) {
		entityManager.getTransaction().begin();
		return ((Session)entityManager.getDelegate()).createCriteria(c).list();
	}

	public T update(T t) {
		return entityManager.merge(t);
	}
	
	
}
