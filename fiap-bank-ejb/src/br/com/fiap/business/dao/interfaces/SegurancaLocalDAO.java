/**
 * 
 */
package br.com.fiap.business.dao.interfaces;

import javax.ejb.Local;

import br.com.fiap.business.exceptions.DAOException;
import br.com.fiap.domain.entity.Seguranca;

/**
 * @author User
 *
 */
@Local
public interface SegurancaLocalDAO extends BasicDAO<Seguranca> {

	/**
	 * Método responsável por buscar na base de dados o usuário <p>
	 * tendo como parâmetro seu login e perfil
	 * @param login
	 * @param perfil
	 * @return {@link Seguranca}
	 * @throws DAOException
	 */
	public Seguranca logar(String login, String perfil)throws DAOException;
}
