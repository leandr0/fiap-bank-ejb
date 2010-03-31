/**
 * 
 */
package br.com.fiap.business.validator;

import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import br.com.fiap.domain.entity.Correntista;
import br.com.fiap.domain.entity.EntityBasic;

/**
 * @author leandro.goncalves
 *
 */
public class AbrirContaPreValidator implements FiapBankValidator {

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.business.validator.FiapBankValidator#validar(br.com.fiap.domain.entity.EntityBasic)
	 */
	@Override
	public <T extends EntityBasic> String validar(T entity) {
		
		ClassValidator<Correntista> validator = new ClassValidator<Correntista>(Correntista.class);
		for(InvalidValue values : validator.getInvalidValues((Correntista) entity)){
			if(!values.getPropertyName().equals("seguranca"))
				return values.getMessage();
		}
		return null;
	}
}
