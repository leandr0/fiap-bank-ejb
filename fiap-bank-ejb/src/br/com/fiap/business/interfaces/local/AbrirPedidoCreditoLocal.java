/**
 * 
 */
package br.com.fiap.business.interfaces.local;

import javax.ejb.Local;

import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
@Local
public interface AbrirPedidoCreditoLocal {

	/**
	 * 
	 * @param credito
	 * @param conta
	 * @return
	 */
	public Credito abrirPedidoCredito(Credito credito,Conta conta);
}
