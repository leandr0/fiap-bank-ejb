/**
 * 
 */
package br.com.fiap.business.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.fiap.business.dao.interfaces.TipoContaLocalDAO;
import br.com.fiap.business.exceptions.DAOException;
import br.com.fiap.domain.entity.TipoConta;

/**
 * @author leandro.goncalves
 *
 */
@Stateless(name = "tipoContaDAO")
@Local(TipoContaLocalDAO.class)
public class TipoContaDAO extends GenericDAO<TipoConta> implements TipoContaLocalDAO {

	/* (non-Javadoc)
	 * @see br.com.fiap.business.dao.interfaces.TipoContaLocalDAO#getTipoContaCorrente()
	 */
	@Override
	public TipoConta getTipoContaCorrente() throws DAOException{
		
		Criteria criteria = ((Session)entityManager.getDelegate()).createCriteria(TipoConta.class);
		
		criteria.add(Restrictions.eq("descricao", "CORRENTE"));
		
		return (TipoConta) criteria.uniqueResult();
	}

}
