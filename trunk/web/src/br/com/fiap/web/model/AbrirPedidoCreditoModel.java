/**
 * 
 */
package br.com.fiap.web.model;

import br.com.fiap.domain.entity.Credito;

/**
 * @author User
 *
 */
public class AbrirPedidoCreditoModel {

	private Credito credito;

	public AbrirPedidoCreditoModel() {
		credito = new Credito();
	}
	
	public Credito getCredito() {
		return credito;
	}

	public void setCredito(Credito credito) {
		this.credito = credito;
	}	
}
