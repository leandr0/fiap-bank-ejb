/**
 * 
 */
package br.com.fiap.business.dao.interfaces;

import javax.ejb.Local;

import br.com.fiap.business.exceptions.DAOException;
import br.com.fiap.domain.entity.TipoConta;

/**
 * @author leandro.goncalves
 *
 */
@Local
public interface TipoContaLocalDAO extends BasicDAO<TipoConta> {

	/**
	 * Recupera o tipoConta onde a descrição se refere a conta corrente 
	 * @return {@link TipoConta}
	 * @throws DAOException
	 */
	public TipoConta getTipoContaCorrente()throws DAOException;
}
