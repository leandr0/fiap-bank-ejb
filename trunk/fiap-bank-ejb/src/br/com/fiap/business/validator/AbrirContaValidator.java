/**
 * 
 */
package br.com.fiap.business.validator;

import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import br.com.fiap.domain.entity.EntityBasic;
import br.com.fiap.domain.entity.Seguranca;

/**
 * @author leandro.goncalves
 *
 */
public class AbrirContaValidator implements FiapBankValidator{

	/* (non-Javadoc)
	 * @see br.com.fiap.business.validator.FiapBankValidator#validar(br.com.fiap.domain.entity.EntityBasic)
	 */
	@Override
	public <T extends EntityBasic> String validar(T entity) {
		
		ClassValidator<Seguranca> validator = new ClassValidator<Seguranca>(Seguranca.class);
		for(InvalidValue values : validator.getInvalidValues((Seguranca) entity)){
			return values.getMessage();
		}
		return null;
	}

}
