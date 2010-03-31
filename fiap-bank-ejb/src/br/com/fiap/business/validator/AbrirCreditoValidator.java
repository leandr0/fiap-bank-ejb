/**
 * 
 */
package br.com.fiap.business.validator;

import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import br.com.fiap.domain.entity.Credito;
import br.com.fiap.domain.entity.EntityBasic;

/**
 * @author leandro.goncalves
 *
 */
public class AbrirCreditoValidator implements FiapBankValidator {

	/* (non-Javadoc)
	 * @see br.com.fiap.business.validator.FiapBankValidator#validar(br.com.fiap.domain.entity.EntityBasic)
	 */
	@Override
	public <T extends EntityBasic> String validar(T entity) {
		
		ClassValidator<Credito> validator = new ClassValidator<Credito>(Credito.class);
		for(InvalidValue values : validator.getInvalidValues((Credito) entity)){
			return values.getMessage();
		}
		return null;
	}

}
