/**
 * 
 */
package br.com.fiap.web.managerbean;

import java.security.Principal;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.fiap.business.interfaces.local.LoginLocal;
import br.com.fiap.domain.entity.Agencia;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Seguranca;

/**
 * @author leandro.goncalves
 *
 */
public abstract class ManagerBean {

	protected String message;

	protected HttpSession session;
	
	@EJB
	private LoginLocal business;
	
	protected String user;
	
	public ManagerBean() {
		createNewSession();
	}
	
	private void createNewSession(){
		session = (HttpSession) 
		getExternalContext().getSession(true);
	}
	
	public String getUser(){
		
		HttpServletRequest request =  (HttpServletRequest) getExternalContext().getRequest();
		Principal principal = request.getUserPrincipal();
		
		return principal.getName();
	}
	
	protected void setAttributeInSession(String attributeName, Object value){
		session.setAttribute(attributeName, value);
	}
	
	protected Object getAttributeInSession(String attributeName){
		return session.getAttribute(attributeName);
	}
	
	protected ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance()
			.getExternalContext();
	}
	
	protected Object getAttributeInContext(String attributeName){
		return getExternalContext().getRequestMap().get(attributeName);
	}
	
	protected Conta getConta() {
		
		HttpServletRequest request =  (HttpServletRequest) getExternalContext().getRequest();
		Principal principal = request.getUserPrincipal();
		
		Seguranca seguranca = business.logar(principal.getName(), "CLIENTE");
		
		if(seguranca == null)
			return null;
		
		return seguranca.getConta();
	}
	
	protected Agencia getAgencia(){
		
		HttpServletRequest request =  (HttpServletRequest) getExternalContext().getRequest();
		Principal principal = request.getUserPrincipal();
	
		Seguranca seguranca = business.logar(principal.getName(), "GERENTE");
		
		if(seguranca == null)
			return null;
		
		return business.logar(principal.getName(), "GERENTE").getFuncionario().getAgencia();
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public HttpSession getSession() {
		
		if(session == null)
			createNewSession();
		
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
}
