/**
 * 
 */
package br.com.fiap.web.managerbean;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;

import br.com.fiap.business.interfaces.local.LoginLocal;
import br.com.fiap.domain.entity.Seguranca;
import br.com.fiap.web.form.LoginForm;
import br.com.fiap.web.model.LoginModel;

/**
 * @author leandro.goncalves
 *
 */
public class LoginMB {

	private LoginForm form;
	
	private LoginModel model;
	
	@EJB
	private LoginLocal business;
	
	/*(mappedName = "fiap-bank-ear/login/remote")*/
	/*private HttpSession session;*/
	
	public LoginMB(){
		form = new LoginForm();
		model = new LoginModel();
	}
	
	public String logar(){
		
		try {
/*			
			LoginContext loginContext = new LoginContext("fiap-bank-policy", new AppCallbackHandler(form.getLogin(), form.getSenha().toCharArray()));
			loginContext.login();
			
			Context context = new InitialContext();
			business = (LoginLocal)context.lookup("fiap-bank-ear/login/local");*/
			
			Seguranca seguranca = business.logar(form.getLogin(), form.getSenha());
			
			if(seguranca != null && seguranca.getPerfil().equals("GERENTE"))
				return "gerente";
			
			else if(seguranca != null && seguranca.getPerfil().equals("CLIENTE"))
				return "cliente";
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String logout(){
		
		try{
		
			ExternalContext context = FacesContext.getCurrentInstance()
									.getExternalContext();
			
			context.getSessionMap().clear();
			
			HttpSession session = ( HttpSession ) context.getSession( true );
			
			session.removeAttribute("j_username");
			session.removeAttribute("j_password");
			session.invalidate();
			
			return "login";
			
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