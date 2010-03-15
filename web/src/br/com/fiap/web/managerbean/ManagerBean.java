/**
 * 
 */
package br.com.fiap.web.managerbean;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * @author leandro.goncalves
 *
 */
public abstract class ManagerBean {

	protected String message;

	protected HttpSession session;
	
	
	public ManagerBean() {
		session = (HttpSession) 
			getExternalContext().getSession(true);
	}
	
	protected void setAttributeInSession(String attributeName, Object value){
		session.setAttribute(attributeName, value);
	}
	
	protected Object getAttributeInSession(String attributeName){
		return session.getAttribute(attributeName);
	}
	
	private ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance()
			.getExternalContext();
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
}
