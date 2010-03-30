/**
 * 
 */
package br.com.fiap.business.exceptions;

import javax.ejb.EJBException;

/**
 * @author leandro.goncalves
 *
 */
public class BusinessException extends EJBException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6130284973340514346L;

	/**
	 * 
	 */
	public BusinessException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public BusinessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ex
	 */
	public BusinessException(Exception ex) {
		super(ex);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param ex
	 */
	public BusinessException(String message, Exception ex) {
		super(message, ex);
		// TODO Auto-generated constructor stub
	}

}
