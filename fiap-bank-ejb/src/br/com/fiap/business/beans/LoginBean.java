/**
 * 
 */
package br.com.fiap.business.beans;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.security.annotation.SecurityDomain;

import br.com.fiap.business.dao.interfaces.SegurancaLocalDAO;
import br.com.fiap.business.exceptions.BusinessException;
import br.com.fiap.business.interfaces.local.LoginLocal;
import br.com.fiap.business.interfaces.remote.LoginRemote;
import br.com.fiap.domain.entity.Seguranca;

/**
 * @author leandro.goncalves
 * 
 */
@Stateless(name = "login")
@Remote(LoginRemote.class)
@Local(LoginLocal.class)
@SecurityDomain("fiap-bank-policy")
public class LoginBean implements LoginLocal, LoginRemote {

	@EJB
	private SegurancaLocalDAO segurancaLocalDAO;
	
	private static Log LOG = LogFactory.getLog(LoginBean.class);
	
	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.business.interfaces.local.LoginLocal#logar(java.lang.String, java.lang.String)
	 */
	@Override
	@PermitAll
	public Seguranca logar(String login, String perfil) throws BusinessException{
		
		LOG.info("Logando para : " + login);		
		
		Seguranca seguranca = null;
			seguranca = segurancaLocalDAO.logar(login, perfil);
			
		return seguranca;

	}
}
