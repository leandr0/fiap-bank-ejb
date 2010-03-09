/**
 * 
 */
package br.com.fiap.business.interfaces.remote;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
@Remote
public interface ConsultarPedidoCreditoRemote {

	/**
	 * 
	 * @param conta
	 * @return
	 */
	public List<Credito> consultarPedidosCredito(Conta conta);
}
