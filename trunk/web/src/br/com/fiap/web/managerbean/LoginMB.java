/**
 * 
 */
package br.com.fiap.web.managerbean;

import javax.ejb.EJB;

import br.com.fiap.business.interfaces.local.LoginLocal;
import br.com.fiap.domain.entity.Seguranca;
import br.com.fiap.web.form.LoginForm;
import br.com.fiap.web.model.LoginModel;

/**
 * @author leandro.goncalves
 *
 */
public class LoginMB extends ManagerBean{

	private LoginForm form;

	private LoginModel model;

	@EJB
	private LoginLocal business;

	public LoginMB(){
		form = new LoginForm();
		model = new LoginModel();
	}

	public String logar(){

		try {

			Seguranca seguranca = business.logar(form.getLogin(), form.getSenha());

			if(seguranca != null){
				if(seguranca.getPerfil().equals("GERENTE"))
					setAttributeInSession("agencia", seguranca.getFuncionario().getAgencia());

				else if(seguranca.getPerfil().equals("CLIENTE"))
					setAttributeInSession("conta", seguranca.getConta());

				return "menu";
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	public String logout(){

		try{
			session.invalidate();
			return "menu";

		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public LoginForm getForm() {
		return form;
	}

	public void setForm(LoginForm form) {
		this.form = form;
	}

	public LoginModel getModel() {
		return model;
	}

	public void setModel(LoginModel model) {
		this.model = model;
	}

	public LoginLocal getBusiness() {
		return business;
	}

	public void setBusiness(LoginLocal business) {
		this.business = business;
	}
}