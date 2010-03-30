/**
 * 
 */
package br.com.fiap.business.exceptions;

import javax.ejb.EJBException;

/**
 * @author leandro.goncalves
 *
 */
public class DAOException extends EJBException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1794886222329016344L;

	/**
	 * 
	 */
	public DAOException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public DAOException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ex
	 */
	public DAOException(Exception ex) {
		super(ex);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param ex
	 */
	public DAOException(String message, Exception ex) {
		super(message, ex);
		// TODO Auto-generated constructor stub
	}

}
