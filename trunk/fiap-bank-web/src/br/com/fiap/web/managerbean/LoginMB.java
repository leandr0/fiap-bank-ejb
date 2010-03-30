/**
 * 
 */
package br.com.fiap.web.managerbean;

import javax.ejb.EJB;

import br.com.fiap.business.interfaces.local.LoginLocal;
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

	public String logout(){
		
		session.invalidate();
		
		return "menu";
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