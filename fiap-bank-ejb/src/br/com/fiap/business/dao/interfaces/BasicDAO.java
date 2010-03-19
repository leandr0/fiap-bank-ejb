/**
 * 
 */
package br.com.fiap.business.dao.interfaces;

import java.util.List;

import br.com.fiap.domain.entity.EntityBasic;

/**
 * @author leandro.goncalves
 *
 */
public interface BasicDAO<T extends EntityBasic> {

	/**
	 * 
	 * @param t
	 * @return
	 */
	public T insert(T t);
	
	/**
	 * 
	 * @param t
	 */
	public void delete(T t);
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public T update(T t);
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public T find(T t);
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public List<T> selectAll(Class<T> c);
}
