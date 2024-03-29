/**
 * 
 */
package br.com.fiap.business.interfaces.remote;

import javax.ejb.Remote;

import br.com.fiap.business.exceptions.BusinessException;
import br.com.fiap.domain.entity.Seguranca;

/**
 * @author leandro.goncalves
 *
 */
@Remote
public interface LoginRemote extends RemoteValidator{

	/**
	 * M�todo respons�vel por recuperar o usu�rio do sistema <p>
	 * pelo login e perfil de acesso 
	 * @param login
	 * @param perfil
	 * @return {@link Seguranca}
	 * @throws BusinessException
	 */
	public Seguranca logar(String login, String perfil) throws BusinessException;
	
}
