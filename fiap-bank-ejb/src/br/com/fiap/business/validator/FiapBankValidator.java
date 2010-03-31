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
	 * Método de validação das entidades
	 * @param entity
	 * @return {@link String}
	 */
	public <T extends EntityBasic> String validar(T entity);
}
