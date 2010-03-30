/**
 * 
 */
package br.com.fiap.web.form;

import java.util.List;

import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
public class AvaliarPedidoCreditoForm {

	private List<Credito> listaCreditos;

	private Long idCredito;
	
	/**
	 * 
	 * @return
	 */
	public Long getIdCredito() {
		return idCredito;
	}

	/**
	 * 
	 * @param idCredito
	 */
	public void setIdCredito(Long idCredito) {
		this.idCredito = idCredito;
	}

	/**
	 * @return the listaCreditos
	 */
	public List<Credito> getListaCreditos() {
		return listaCreditos;
	}

	/**
	 * @param listaCreditos the listaCreditos to set
	 */
	public void setListaCreditos(List<Credito> listaCreditos) {
		this.listaCreditos = listaCreditos;
	}
}
