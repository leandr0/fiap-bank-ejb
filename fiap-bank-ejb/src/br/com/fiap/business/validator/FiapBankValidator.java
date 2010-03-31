/**
 * 
 */
package br.com.fiap.business.validator;

import br.com.fiap.domain.entity.EntityBasic;

/**
 * @author User
 *
 */
public interface FiapBankValidator {

	/**
	 * M�todo de valida��o das entidades
	 * @param entity
	 * @return {@link String}
	 */
	public <T extends EntityBasic> String validar(T entity);
}
