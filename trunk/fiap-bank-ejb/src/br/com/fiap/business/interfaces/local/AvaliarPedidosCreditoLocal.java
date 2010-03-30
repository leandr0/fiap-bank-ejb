/**
 * 
 */
package br.com.fiap.business.interfaces.local;

import java.util.List;

import javax.ejb.Local;

import br.com.fiap.business.exceptions.BusinessException;
import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
@Local
public interface AvaliarPedidosCreditoLocal {

	/**
	 *  Método recupera na base de dados todos os créditos com status SUJEITO_A_APROVACAO
	 * @return {@link List}< {@link Credito} >
	 * @throws BusinessException
	 */
	public List<Credito> recuperarListaCreditos() throws BusinessException;

	/**
	 *  Método atualiza o crédito passado como parâmetro para o status APROVADO <p>
	 *  e recupera na base de dados todos os créditos com status SUJEITO_A_APROVACAO
	 * @param credito
	 * @return {@link List}< {@link Credito} >
	 * @throws BusinessException
	 */
	public List<Credito> aprovarCredito(Credito credito) throws BusinessException;
	
	/**
	 * Método atualiza o crédito passado como parâmetro para o status RECUSADO <p>
	 *  e recupera na base de dados todos os créditos com status SUJEITO_A_APROVACAO
	 * @param credito
	 * @return {@link List}< {@link Credito} >
	 * @throws BusinessException
	 */
	public List<Credito> reprovarCredito(Credito credito) throws BusinessException;
}
