/**
 * 
 */
package br.com.fiap.domain.entity;

import java.io.Serializable;

/**
 * @author User
 *
 */
public interface EntityBasic extends Serializable{

	/**
	 * 
	 * @param id
	 */
	public void setId(Long id);
	
	/**
	 * 
	 * @return
	 */
	public Long getId();
}
