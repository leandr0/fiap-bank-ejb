/**
 * 
 */
package br.com.fiap.web.managerbean;

import javax.ejb.EJB;

import br.com.fiap.business.interfaces.local.AbrirPedidoCreditoLocal;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.web.form.AbrirPedidoCreditoForm;
import br.com.fiap.web.model.AbrirPedidoCreditoModel;

/**
 * @author leandro.goncalves
 *
 */
public class AbrirPedidoCreditoMB extends ManagerBean{

	private AbrirPedidoCreditoForm form;
	
	private AbrirPedidoCreditoModel model;
	
	@EJB
	private AbrirPedidoCreditoLocal business;

	
	public AbrirPedidoCreditoMB() {
		inicializar();
	}
	
	
	public String solicitarCredito(){
		
		try{
		business.abrirPedidoCredito(model.getCredito(), getConta());
		}catch (Exception e) {
		}
		return null;
	}
	
	public String confirmarCredito(){
		inicializar();
		return "menu";
	}
	
	public String novaSolicitacaoCredito(){
		inicializar();
		return null;
	}
	
	public String inicializar(){
		
		form  = new AbrirPedidoCreditoForm();
		model = new AbrirPedidoCreditoModel();
		
		return "abrir-pedido-credito";
	}
	
	public AbrirPedidoCreditoForm getForm() {
		return form;
	}

	public void setForm(AbrirPedidoCreditoForm form) {
		this.form = form;
	}

	public AbrirPedidoCreditoModel getModel() {
		return model;
	}

	public void setModel(AbrirPedidoCreditoModel model) {
		this.model = model;
	}

	public AbrirPedidoCreditoLocal getBusiness() {
		return business;
	}

	public void setBusiness(AbrirPedidoCreditoLocal business) {
		this.business = business;
	}
}
