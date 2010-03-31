/**
 * 
 */
package br.com.fiap.business.interfaces.remote;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.business.exceptions.BusinessException;
import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
@Remote
public interface AvaliarPedidosCreditoRemote{

	/**
	 *  M�todo recupera na base de dados todos os cr�ditos com status SUJEITO_A_APROVACAO
	 * @return {@link List}< {@link Credito} >
	 * @throws BusinessException
	 */
	public List<Credito> recuperarListaCreditos() throws BusinessException;

	/**
	 *  M�todo atualiza o cr�dito passado como par�metro para o status APROVADO <p>
	 *  e recupera na base de dados todos os cr�ditos com status SUJEITO_A_APROVACAO
	 * @param credito
	 * @return {@link List}< {@link Credito} >
	 * @throws BusinessException
	 */
	public List<Credito> aprovarCredito(Credito credito) throws BusinessException;
	
	/**
	 * M�todo atualiza o cr�dito passado como par�metro para o status RECUSADO <p>
	 *  e recupera na base de dados todos os cr�ditos com status SUJEITO_A_APROVACAO
	 * @param credito
	 * @return {@link List}< {@link Credito} >
	 * @throws BusinessException
	 */
	public List<Credito> reprovarCredito(Credito credito) throws BusinessException;
	
}
