/**
 * 
 */
package br.com.fiap.business.dao.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
@Local
public interface CreditoLocalDAO extends BasicDAO<Credito> {

	/**
	 * 
	 * @param conta
	 * @return
	 */
	public List<Credito> listarCreditoConta(Conta conta);
	
	/**
	 * 
	 * @return
	 */
	public List<Credito> listaCreditoAvaliacao();
}
