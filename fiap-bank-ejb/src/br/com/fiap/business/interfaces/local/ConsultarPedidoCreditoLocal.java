/**
 * 
 */
package br.com.fiap.business.interfaces.local;

import java.util.List;

import javax.ejb.Local;

import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
@Local
public interface ConsultarPedidoCreditoLocal {

	/**
	 * 
	 * @param conta
	 * @return
	 */
	public List<Credito> consultarPedidosCredito(Conta conta);
	
}
