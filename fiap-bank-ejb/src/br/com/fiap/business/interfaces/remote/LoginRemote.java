/**
 * 
 */
package br.com.fiap.business.interfaces.remote;

import javax.ejb.Remote;
import javax.security.auth.login.LoginException;

import br.com.fiap.domain.entity.Seguranca;

/**
 * @author leandro.goncalves
 *
 */
@Remote
public interface LoginRemote {

	/**
	 * 
	 * @param login
	 * @param perfil
	 * @return
	 * @throws LoginException
	 */
	public Seguranca logar(String login, String perfil) throws LoginException ;
	
}
