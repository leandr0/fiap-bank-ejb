/**
 * 
 */
package br.com.fiap.business.interfaces.remote;

import javax.ejb.Remote;

import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
@Remote
public interface AbrirPedidoCreditoRemote {

	/**
	 * 
	 * @param credito
	 * @param conta
	 * @return
	 */
	public Credito abrirPedidoCredito(Credito credito,Conta conta);
	
}
