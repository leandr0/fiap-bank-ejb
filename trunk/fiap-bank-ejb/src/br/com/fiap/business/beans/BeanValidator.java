/**
 * 
 */
package br.com.fiap.business.beans;

import br.com.fiap.business.validator.FiapBankValidator;

/**
 * @author leandro.goncalves
 *
 */
public abstract class BeanValidator {

	protected String messageValidator;
	
	protected boolean valid;

	protected FiapBankValidator validator;
	
	public String getMessageValidator() {
		return messageValidator;
	}

	public void setMessageValidator(String messageValidator) {
		this.messageValidator = messageValidator;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
