/**
 * 
 */
package br.com.fiap.web.managerbean;

import javax.ejb.EJB;

import br.com.fiap.business.interfaces.local.AbrirContaLocal;
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
		inicializar();
	}

	public String abrirConta(){

		business.abrirConta(model.getCorrentista(),getAgencia());
		
		form.setValid(business.isValid());
		form.setMensagem(business.getMessageValidator());
		
		return null;
	}

	public String adicionarSenha(){

		business.adicionarSenha(model.getCorrentista(),model.getSeguranca());

		form.setCodigoConta(model.getCorrentista().getConta().getCodigoConta());

		form.setValid(business.isValid());
		form.setMensagem(business.getMessageValidator());
		
		return null;
	}

	public String inicializar(){

		form  = new AbrirContaForm();
		model = new AbrirContaModel();

		return "abrir-conta";
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
