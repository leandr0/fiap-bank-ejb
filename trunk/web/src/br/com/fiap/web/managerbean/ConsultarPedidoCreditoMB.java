/**
 * 
 */
package br.com.fiap.web.managerbean;

import javax.ejb.EJB;

import br.com.fiap.business.interfaces.local.ConsultarPedidoCreditoLocal;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.web.form.ConsultarPedidoCreditoForm;
import br.com.fiap.web.model.ConsultarPedidoCreditoModel;

/**
 * @author leandro.goncalves
 *
 */
public class ConsultarPedidoCreditoMB extends ManagerBean{

	private ConsultarPedidoCreditoForm form;
	
	private ConsultarPedidoCreditoModel model;
	
	@EJB
	private ConsultarPedidoCreditoLocal business;

	
	public ConsultarPedidoCreditoMB() {
		inicializar();
	}
	
	
	public String consultarCredito(){
		form.setListaCreditos(
				business.consultarPedidosCredito(
						(Conta)getAttributeInSession("conta")));
		return null;
	}
	
	
	private void inicializar(){
		form  = new ConsultarPedidoCreditoForm();
		model = new ConsultarPedidoCreditoModel();
	}
	
	/**
	 * @return the form
	 */
	public ConsultarPedidoCreditoForm getForm() {
		return form;
	}

	/**
	 * @param form the form to set
	 */
	public void setForm(ConsultarPedidoCreditoForm form) {
		this.form = form;
	}

	/**
	 * @return the model
	 */
	public ConsultarPedidoCreditoModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(ConsultarPedidoCreditoModel model) {
		this.model = model;
	}

	/**
	 * @return the business
	 */
	public ConsultarPedidoCreditoLocal getBusiness() {
		return business;
	}

	/**
	 * @param business the business to set
	 */
	public void setBusiness(ConsultarPedidoCreditoLocal business) {
		this.business = business;
	}	
}