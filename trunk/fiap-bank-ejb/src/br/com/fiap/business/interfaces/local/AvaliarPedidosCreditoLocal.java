/**
 * 
 */
package br.com.fiap.business.interfaces.local;

import java.util.List;

import javax.ejb.Local;

import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
@Local
public interface AvaliarPedidosCreditoLocal {

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
