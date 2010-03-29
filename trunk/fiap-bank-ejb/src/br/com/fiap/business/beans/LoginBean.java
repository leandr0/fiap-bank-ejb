/**
 * 
 */
package br.com.fiap.business.beans;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.security.auth.login.LoginException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.fiap.business.dao.interfaces.SegurancaLocalDAO;
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
public class LoginBean implements LoginLocal, LoginRemote {

	@EJB
	private SegurancaLocalDAO segurancaLocalDAO;
	
	/**
	 * 
	 */
	private static Log LOG = LogFactory.getLog(LoginBean.class);
	
	@Override
	public Seguranca logar(String login, String perfil) throws LoginException {

		LOG.info("Logando para : " + login);		
		
		Seguranca seguranca = null;

		try {
			
			seguranca = segurancaLocalDAO.logar(login, perfil);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return seguranca;

	}
}
