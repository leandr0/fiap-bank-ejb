/**
 * 
 */
package br.com.fiap.business.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.fiap.business.dao.interfaces.SegurancaLocalDAO;
import br.com.fiap.domain.entity.Seguranca;

/**
 * @author User
 *
 */
@Stateless(name = "segurancaDAO")
@Local(SegurancaLocalDAO.class)
public class SegurancaDAO extends GenericDAO<Seguranca> implements SegurancaLocalDAO {

	/* (non-Javadoc)
	 * @see br.com.fiap.business.dao.interfaces.SegurancaLocalDAO#logar(java.lang.String, java.lang.String)
	 */
	@Override
	public Seguranca logar(String login, String perfil) {
		
		Criteria criteria = ((Session)entityManager.getDelegate()).createCriteria(Seguranca.class);
		
		criteria.add(Restrictions.and(Restrictions.eq("login", login),
				Restrictions.eq("perfil", perfil)));
		
		return (Seguranca) criteria.uniqueResult();
	}
	
}
