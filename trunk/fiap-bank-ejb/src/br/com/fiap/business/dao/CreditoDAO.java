/**
 * 
 */
package br.com.fiap.business.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fiap.business.dao.interfaces.CreditoLocalDAO;
import br.com.fiap.business.exceptions.DAOException;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Credito;
import br.com.fiap.domain.enums.StatusCredito;

/**
 * @author leandro.goncalves
 *
 */
@SuppressWarnings("unchecked")
@Stateless(name = "creditoDAO")
@Local(CreditoLocalDAO.class)
public class CreditoDAO extends GenericDAO<Credito> implements CreditoLocalDAO {

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.business.dao.interfaces.CreditoLocalDAO#listarCreditoConta(br.com.fiap.domain.entity.Conta)
	 */
	@Override
	public List<Credito> listarCreditoConta(Conta conta) throws DAOException{
		
		Criteria criteria = ((Session)entityManager.getDelegate()).createCriteria(Credito.class);
		
		return criteria.addOrder(Order.asc("statusCredito"))
				.add(Restrictions.eq("conta.id", conta.getId())).list();
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.business.dao.interfaces.CreditoLocalDAO#listaCreditoAvaliacao()
	 */
	@Override
	public List<Credito> listaCreditoAvaliacao() throws DAOException{
		
		Criteria criteria = ((Session)entityManager.getDelegate()).createCriteria(Credito.class);
		
		criteria.add(Restrictions.eq("statusCredito", StatusCredito.SUJEITO_A_APROVACAO));
		
		return criteria.list();
	}
	
}
