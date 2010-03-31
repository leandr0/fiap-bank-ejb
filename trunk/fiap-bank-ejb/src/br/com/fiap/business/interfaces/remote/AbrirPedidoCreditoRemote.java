/**
 * 
 */
package br.com.fiap.business.interfaces.remote;

import javax.ejb.Remote;

import br.com.fiap.business.exceptions.BusinessException;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
@Remote
public interface AbrirPedidoCreditoRemote extends RemoteValidator{


	/**
	 * Método responsável pela avaliação do pedido de crédito
	 * @param credito
	 * @param conta
	 * @return {@link Credito}
	 * @throws BusinessException
	 */
	public Credito avaliarPedidoCredito(Credito credito,Conta conta) throws BusinessException;
	
	/**
	 * Método responsável por persistir as entidades para registro do crédito 
	 * @param credito
	 * @param conta
	 * @return {@link Credito}
	 * @throws BusinessException
	 */
	public Credito abrirPedidoCredito(Credito credito,Conta conta) throws BusinessException;
}
