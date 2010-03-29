/**
 * 
 */
package br.com.fiap.business.interfaces.local;

import javax.ejb.Local;
import javax.security.auth.login.LoginException;

import br.com.fiap.domain.entity.Seguranca;

/**
 * @author leandro.goncalves
 *
 */
@Local
public interface LoginLocal {

	/**
	 * 
	 * @param login
	 * @param perfil
	 * @return
	 * @throws LoginException
	 */
	public Seguranca logar(String login, String perfil) throws LoginException ;

}