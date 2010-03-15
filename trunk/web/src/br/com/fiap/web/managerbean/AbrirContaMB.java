/**
 * 
 */
package br.com.fiap.web.managerbean;

import javax.ejb.EJB;

import br.com.fiap.business.interfaces.local.AbrirContaLocal;
import br.com.fiap.domain.entity.Agencia;
import br.com.fiap.web.form.AbrirContaForm;
import br.com.fiap.web.model.AbrirContaModel;

/**
 * @author leandro.goncalves
 *
 */
public class AbrirContaMB extends ManagerBean{

	private AbrirContaForm form;
	
	private AbrirContaModel model;

	@EJB
	private AbrirContaLocal business;
	
	public AbrirContaMB(){
		init();
	}
	
	public String abrirConta(){
	
		business.abrirConta(model.getCorrentista(),
				(Agencia)getAttributeInSession("agencia"));
		
		return null;
	}
	
	public String adicionarSenha(){
		
		business.adicionarSenha(model.getCorrentista().getConta(),model.getSeguranca());
		
		return null;
	}
	
	private void init(){
		form  = new AbrirContaForm();
		model = new AbrirContaModel();
	}
	
	public AbrirContaForm getForm() {
		return form;
	}

	public void setForm(AbrirContaForm form) {
		this.form = form;
	}

	public AbrirContaModel getModel() {
		return model;
	}

	public void setModel(AbrirContaModel model) {
		this.model = model;
	}
}
