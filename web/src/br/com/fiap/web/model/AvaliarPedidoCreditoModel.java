/**
 * 
 */
package br.com.fiap.web.model;

import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
public class AvaliarPedidoCreditoModel {

	private Credito credito;

	
	public AvaliarPedidoCreditoModel() {
		this.credito = new Credito();
	}
	
	/**
	 * @return the credito
	 */
	public Credito getCredito() {
		return credito;
	}

	/**
	 * @param credito the credito to set
	 */
	public void setCredito(Credito credito) {
		this.credito = credito;
	}
}
