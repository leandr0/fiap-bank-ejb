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
public class ConsultarPedidoCreditoForm {

	private List<Credito> listaCreditos;

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
