/**
 * 
 */
package br.com.fiap.business.beans;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author leandro.goncalves
 *
 */
public abstract class AbstractPersistenceContextBean {

	@PersistenceContext(name = "fiap")
	EntityManager entityManager;
}