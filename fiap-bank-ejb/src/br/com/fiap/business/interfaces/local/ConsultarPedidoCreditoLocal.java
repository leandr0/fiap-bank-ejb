/**
 * 
 */
package br.com.fiap.business.interfaces.local;

import java.util.List;

import javax.ejb.Local;

import br.com.fiap.business.exceptions.BusinessException;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
@Local
public interface ConsultarPedidoCreditoLocal{

	/**
	 * Método responsável por consultar na base de dados os créditos<p>
	 * atrelados a conta passada como parâmetro
	 * @param conta
	 * @return {@link List}< {@link Credito} >
	 * @throws BusinessException
	 */
	public List<Credito> consultarPedidosCredito(Conta conta) throws BusinessException;
	
}
