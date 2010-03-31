/**
 * 
 */
package br.com.fiap.validator.validadores;

import org.hibernate.validator.Validator;

/**
 * @author leandro.goncalves
 *
 */
public class NumberNotZero implements Validator<ValueNotZero> {

	@Override
	public void initialize(ValueNotZero arg0) {
	}

	@Override
	public boolean isValid(Object object) {
		try{
			
			if(object == null)
				return false;

			Double decimal = new Double(object.toString());

			if(decimal.doubleValue() > 0)
				return true;

		}catch (Exception e) {
			System.err.println("Erro ao validar valor");
		}
		return false;
	}

}