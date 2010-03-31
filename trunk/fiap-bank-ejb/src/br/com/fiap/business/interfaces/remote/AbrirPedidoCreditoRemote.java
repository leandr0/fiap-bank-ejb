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
	 * M�todo respons�vel pela avalia��o do pedido de cr�dito
	 * @param credito
	 * @param conta
	 * @return {@link Credito}
	 * @throws BusinessException
	 */
	public Credito avaliarPedidoCredito(Credito credito,Conta conta) throws BusinessException;
	
	/**
	 * M�todo respons�vel por persistir as entidades para registro do cr�dito 
	 * @param credito
	 * @param conta
	 * @return {@link Credito}
	 * @throws BusinessException
	 */
	public Credito abrirPedidoCredito(Credito credito,Conta conta) throws BusinessException;
}
