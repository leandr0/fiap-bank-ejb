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
	 * @param senha
	 * @return
	 * @throws LoginException
	 */
	public Seguranca logar(String login, String senha) throws LoginException ;
	
}