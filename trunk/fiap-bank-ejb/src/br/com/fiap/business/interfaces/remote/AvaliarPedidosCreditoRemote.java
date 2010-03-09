/**
 * 
 */
package br.com.fiap.business.interfaces.remote;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
@Remote
public interface AvaliarPedidosCreditoRemote {

	/**
	 * 
	 * @return
	 */
	public List<Credito> recuperarListaCreditos();

	/**
	 * 
	 * @param credito
	 * @return
	 */
	public List<Credito> aprovarCredito(Credito credito);
	
	/**
	 * 
	 * @param credito
	 * @return
	 */
	public List<Credito> reprovarCredito(Credito credito);
	
}
