/**
 * 
 */
package br.com.fiap.web.managerbean;

import javax.ejb.EJB;

import br.com.fiap.business.interfaces.local.AvaliarPedidosCreditoLocal;
import br.com.fiap.web.form.AvaliarPedidoCreditoForm;
import br.com.fiap.web.model.AvaliarPedidoCreditoModel;

/**
 * @author leandro.goncalves
 *
 */
public class AvaliarPedidoCreditoMB extends ManagerBean{

	private AvaliarPedidoCreditoForm form;
	
	private AvaliarPedidoCreditoModel model;
	
	@EJB
	private AvaliarPedidosCreditoLocal business;
	
	public AvaliarPedidoCreditoMB() {
		inicializar();
	}
	
	private void inicializar(){
		form  = new AvaliarPedidoCreditoForm();
		model = new AvaliarPedidoCreditoModel(); 
	}

	public String carregarListaCredito(){
	
		form.setListaCreditos(business.recuperarListaCreditos());
		
		return "avaliar-pedido-credito";
	}
	
	public String aprovarCredito(){
	
		business.aprovarCredito(model.getCredito());
		
		carregarListaCredito();
		
		return null;
	}
	
	public String reprovarCredito(){
		
		business.reprovarCredito(model.getCredito());
		
		carregarListaCredito();
		
		return null;
	}
	
	/**
	 * @return the form
	 */
	public AvaliarPedidoCreditoForm getForm() {
		return form;
	}

	/**
	 * @param form the form to set
	 */
	public void setForm(AvaliarPedidoCreditoForm form) {
		this.form = form;
	}

	/**
	 * @return the model
	 */
	public AvaliarPedidoCreditoModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(AvaliarPedidoCreditoModel model) {
		this.model = model;
	}
}
