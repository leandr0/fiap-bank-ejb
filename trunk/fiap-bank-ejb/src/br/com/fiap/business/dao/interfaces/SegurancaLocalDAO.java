/**
 * 
 */
package br.com.fiap.business.dao.interfaces;

import javax.ejb.Local;

import br.com.fiap.domain.entity.Seguranca;

/**
 * @author User
 *
 */
@Local
public interface SegurancaLocalDAO extends BasicDAO<Seguranca> {

	/**
	 * 
	 * @param login
	 * @param perfil
	 * @return
	 */
	public Seguranca logar(String login, String perfil);
}
