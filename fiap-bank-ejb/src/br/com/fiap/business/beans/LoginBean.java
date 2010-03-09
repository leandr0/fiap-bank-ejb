/**
 * 
 */
package br.com.fiap.business.beans;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.security.auth.callback.AppCallbackHandler;

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
public class LoginBean extends AbstractPersistenceContextBean implements
		LoginLocal, LoginRemote {

	/**
	 * 
	 */
	private static Log LOG = LogFactory.getLog(LoginBean.class);

	@Override
	public Seguranca logar(String login, String senha) throws LoginException {

		LOG.info("Logando para : " + login);

		LoginContext loginContext = new LoginContext("fiap-bank-policy",
				new AppCallbackHandler(login, senha.toCharArray()));
		loginContext.login();

		Seguranca seguranca = null;

		try {

			/*
			 * String jpql = "select c from "+Conta.class.getName()+" c "+
			 * "inner join c.seguranca s "+ "where s.login = :login "+
			 * "and s.senha = :senha";
			 */

			String jpql = "SELECT s FROM "+Seguranca.class.getName()+" s "
						+"WHERE s.login = :login " + "AND s.senha = :senha";

			Query query = entityManager.createQuery(jpql);

			query.setParameter("login", login).setParameter("senha", senha);

			seguranca = (Seguranca) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return seguranca;

	}

}
