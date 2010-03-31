/**
 * 
 */
package br.com.fiap.business.interfaces.remote;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.business.exceptions.BusinessException;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
@Remote
public interface ConsultarPedidoCreditoRemote{

	/**
	 * M�todo respons�vel por consultar na base de dados os cr�ditos<p>
	 * atrelados a conta passada como par�metro
	 * @param conta
	 * @return {@link List}< {@link Credito} >
	 * @throws BusinessException
	 */
	public List<Credito> consultarPedidosCredito(Conta conta) throws BusinessException;
}
