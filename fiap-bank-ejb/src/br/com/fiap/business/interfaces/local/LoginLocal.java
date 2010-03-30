/**
 * 
 */
package br.com.fiap.business.interfaces.local;

import javax.ejb.Local;

import br.com.fiap.business.exceptions.BusinessException;
import br.com.fiap.domain.entity.Seguranca;

/**
 * @author leandro.goncalves
 *
 */
@Local
public interface LoginLocal {

	/**
	 * Método responsável por recuperar o usuário do sistema <p>
	 * pelo login e perfil de acesso 
	 * @param login
	 * @param perfil
	 * @return {@link Seguranca}
	 * @throws BusinessException
	 */
	public Seguranca logar(String login, String perfil) throws BusinessException;

}
